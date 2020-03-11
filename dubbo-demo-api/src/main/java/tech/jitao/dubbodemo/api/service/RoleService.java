package tech.jitao.dubbodemo.api.service;

import tech.jitao.dubbodemo.api.domain.Role;
import tech.jitao.dubbodemo.api.dto.CommonListRequest;
import tech.jitao.dubbodemo.api.exception.NotFoundException;

import java.util.List;

public interface RoleService {
    List<Role> listRoles(CommonListRequest request);

    Role getRole(int id) throws NotFoundException;

    Role createRole(Role role);

    Role updateRole(Role role);
}
