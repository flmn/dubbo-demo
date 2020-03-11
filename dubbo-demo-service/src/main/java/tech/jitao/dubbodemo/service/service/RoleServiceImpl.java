package tech.jitao.dubbodemo.service.service;

import org.apache.dubbo.config.annotation.Service;
import tech.jitao.dubbodemo.api.domain.Role;
import tech.jitao.dubbodemo.api.dto.CommonListRequest;
import tech.jitao.dubbodemo.api.exception.NotFoundException;
import tech.jitao.dubbodemo.api.service.RoleService;
import tech.jitao.dubbodemo.service.entity.RoleEntity;
import tech.jitao.dubbodemo.service.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service(version = "1.0.0")
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> listRoles(CommonListRequest request) {
        return null;
    }

    @Override
    public Role getRole(int id) throws NotFoundException {
        Optional<RoleEntity> opt = roleRepository.findById(id);
        if (!opt.isPresent()) {
            throw new NotFoundException();
        }

        return opt.get().toRole();
    }

    @Override
    public Role createRole(Role role) {
        return null;
    }

    @Override
    public Role updateRole(Role role) {
        return null;
    }
}
