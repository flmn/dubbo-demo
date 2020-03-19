package tech.jitao.dubbodemo.service.service;

import org.apache.dubbo.config.annotation.Service;
import tech.jitao.dubbodemo.api.domain.Privilege;
import tech.jitao.dubbodemo.api.exception.NotFoundException;
import tech.jitao.dubbodemo.api.service.PrivilegeService;
import tech.jitao.dubbodemo.service.entity.PrivilegeEntity;
import tech.jitao.dubbodemo.service.repository.PrivilegeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service(version = "1.0.0")
public class PrivilegeServiceImpl implements PrivilegeService {
    private final PrivilegeRepository privilegeRepository;

    public PrivilegeServiceImpl(PrivilegeRepository privilegeRepository) {
        this.privilegeRepository = privilegeRepository;
    }

    @Override
    public List<Privilege> listPrivileges() {
        return privilegeRepository.findAllByOrderBySortOrderDesc().stream().map(PrivilegeEntity::toPrivilege).collect(Collectors.toList());
    }

    @Override
    public Privilege getPrivilege(String id) throws NotFoundException {
        Optional<PrivilegeEntity> opt = privilegeRepository.findById(id);
        if (!opt.isPresent()) {
            throw new NotFoundException();
        }

        return opt.get().toPrivilege();
    }
}
