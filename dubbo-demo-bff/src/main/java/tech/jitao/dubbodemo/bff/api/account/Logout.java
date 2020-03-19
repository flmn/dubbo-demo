package tech.jitao.dubbodemo.bff.api.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import tech.jitao.dubbodemo.bff.common.ApiResult;
import tech.jitao.dubbodemo.bff.config.RequestHeaders;
import tech.jitao.dubbodemo.bff.config.auth.NoAuth;
import tech.jitao.dubbodemo.bff.service.AuthService;

@RestController(Logout.PATH)
@CrossOrigin
@NoAuth
public class Logout {
    static final String PATH = "/account/logout";

    @Autowired
    private AuthService authService;

    @PostMapping(PATH)
    public ApiResult process(@RequestHeader(value = RequestHeaders.ACCESS_TOKEN, required = false) String accessToken) {
        authService.logout(accessToken);

        return ApiResult.ok();
    }
}
