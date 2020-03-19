package tech.jitao.dubbodemo.api.service;

import tech.jitao.dubbodemo.api.domain.Privilege;
import tech.jitao.dubbodemo.api.exception.NotFoundException;

import java.util.List;

public interface PrivilegeService {
    List<Privilege> listPrivileges();
    Privilege getPrivilege(String id) throws NotFoundException;
}
