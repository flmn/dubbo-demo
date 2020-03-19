package tech.jitao.dubbodemo.bff.service;

import com.google.common.base.Strings;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import tech.jitao.dubbodemo.api.domain.Staff;
import tech.jitao.dubbodemo.api.dto.AuthenticateResponse;
import tech.jitao.dubbodemo.api.exception.MessageException;
import tech.jitao.dubbodemo.api.service.StaffService;
import tech.jitao.dubbodemo.bff.config.RedisKeys;
import tech.jitao.dubbodemo.bff.config.profile.ProfileConfig;
import tech.jitao.dubbodemo.bff.dto.LoginInfoDto;
import tech.jitao.dubbodemo.bff.util.UuidHelper;

import java.util.concurrent.TimeUnit;

@Service
public class AuthService {
    private static final String TEST_TOKEN = "D8d8lKFtXdQ15Y5VoZm2UHQI8UZGGk17kArOFR7I";
    private static final int LOGIN_TTL = 7; // days
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ProfileConfig profileConfig;
    private final StringRedisTemplate redis;

    @Reference(version = "1.0.0")
    private StaffService staffService;

    public AuthService(ProfileConfig profileConfig,
                       StringRedisTemplate redis) {
        this.profileConfig = profileConfig;
        this.redis = redis;
    }

    public LoginInfoDto login(String username, String password) throws MessageException {
        // check
        AuthenticateResponse response = staffService.authenticate(username, password);
        if (response == null) {
            throw new MessageException("用户名或密码错误");
        }

        Staff staff = response.getStaff();

        // gen token and save to redis
        String token = genToken();
        String keyToken = String.format(RedisKeys.SESSION, token);
        HashOperations<String, String, String> hashOperations = redis.opsForHash();
        hashOperations.put(keyToken, "staffId", String.valueOf(staff.getId()));
        redis.expire(keyToken, LOGIN_TTL, TimeUnit.DAYS);
        logger.info("Staff {}({}) login with token {}", staff.getUsername(), staff.getId(), token);

        LoginInfoDto dto = new LoginInfoDto();
        dto.setAccessToken(token);
        dto.setExpireDays(LOGIN_TTL);
        dto.setPrivileges(response.getPrivileges());

        return dto;
    }

    public void logout(String accessToken) {
        if (!Strings.isNullOrEmpty(accessToken)) {
            String keyToken = String.format(RedisKeys.SESSION, accessToken);
            redis.delete(keyToken);

            logger.info("User with access token {} logout.", accessToken);
        }
    }

    public long getUserIdByToken(String token) {
        String key = String.format(RedisKeys.SESSION, token);

        Object userId = redis.opsForHash().get(key, "userId");

        return NumberUtils.toLong(userId == null ? null : userId.toString(), 0L);
    }

    private String genToken() {
        return profileConfig.getEnv() == ProfileConfig.ENV_DEV
                ? TEST_TOKEN
                : RandomStringUtils.randomAlphanumeric(8) + UuidHelper.gen() + RandomStringUtils.randomAlphanumeric(8);
    }
}
