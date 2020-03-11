package tech.jitao.dubbodemo.service.service;

import org.apache.dubbo.config.annotation.Service;
import tech.jitao.dubbodemo.api.domain.Privilege;
import tech.jitao.dubbodemo.api.service.PrivilegeService;
import tech.jitao.dubbodemo.service.repository.PrivilegeRepository;

import java.util.List;

@Service(version = "1.0.0")
public class PrivilegeServiceImpl implements PrivilegeService {
    private final PrivilegeRepository privilegeRepository;

    public PrivilegeServiceImpl(PrivilegeRepository privilegeRepository) {
        this.privilegeRepository = privilegeRepository;
    }

    @Override
    public List<Privilege> listPrivileges() {
        return null;
    }
}
