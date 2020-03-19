package tech.jitao.dubbodemo.api.service;

import tech.jitao.dubbodemo.api.domain.Role;
import tech.jitao.dubbodemo.api.dto.CommonListRequest;
import tech.jitao.dubbodemo.api.dto.ListResponse;
import tech.jitao.dubbodemo.api.exception.NotFoundException;

public interface RoleService {
    ListResponse<Role> listRoles(CommonListRequest request);

    Role getRole(int id) throws NotFoundException;

    Role createRole(Role role);

    Role updateRole(Role role);
}
