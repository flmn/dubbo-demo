package tech.jitao.dubbodemo.service.service;

import com.google.common.collect.Sets;
import org.apache.dubbo.config.annotation.Service;
import tech.jitao.dubbodemo.api.domain.Staff;
import tech.jitao.dubbodemo.api.dto.AuthenticateResponse;
import tech.jitao.dubbodemo.api.dto.CommonListRequest;
import tech.jitao.dubbodemo.api.exception.MessageException;
import tech.jitao.dubbodemo.api.service.StaffService;
import tech.jitao.dubbodemo.service.entity.PrivilegeEntity;
import tech.jitao.dubbodemo.service.entity.StaffEntity;
import tech.jitao.dubbodemo.service.repository.PrivilegeRepository;
import tech.jitao.dubbodemo.service.repository.StaffRepository;
import tech.jitao.dubbodemo.service.util.BooleanString;
import tech.jitao.dubbodemo.service.util.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service(version = "1.0.0")
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;
    private final PrivilegeRepository privilegeRepository;
    private final PasswordEncoder passwordEncoder;

    public StaffServiceImpl(StaffRepository staffRepository,
                            PrivilegeRepository privilegeRepository,
                            PasswordEncoder passwordEncoder) {
        this.staffRepository = staffRepository;
        this.privilegeRepository = privilegeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Staff> listStaffs(CommonListRequest request) {
        return null;
    }

    @Override
    public Staff getStaff(long id) {
        return null;
    }

    @Override
    public Staff createStaff(Staff staff) {
        return null;
    }

    @Override
    public Staff updateStaff(Staff staff) {
        return null;
    }

    @Override
    public AuthenticateResponse authenticate(String username, String password) throws MessageException {
        Optional<StaffEntity> opt = staffRepository.findByUsername(username);
        if (!opt.isPresent()) {
            throw new MessageException("用户名或密码错误！");
        }

        StaffEntity entity = opt.get();

        if (!passwordEncoder.matches(password, entity.getPassword())) {
            throw new MessageException("用户名或密码错误！");
        }

        if (BooleanString.toBool(entity.getIsLocked())) {
            throw new MessageException("账户被锁定，请联系管理员。");
        }

        entity.setLastLoginTime(LocalDateTime.now());
        staffRepository.save(entity);

        Set<String> privileges = Sets.newHashSet();
        entity.getRoles().forEach(r -> privileges.addAll(r.getPrivileges().stream().map(PrivilegeEntity::getId).collect(Collectors.toSet())));

        AuthenticateResponse response = new AuthenticateResponse();
        response.setStaff(entity.toStaff());
        response.setPrivileges(privileges);

        return response;
    }
}
