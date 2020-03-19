package tech.jitao.dubbodemo.bff.api.role;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.jitao.dubbodemo.api.domain.Privilege;
import tech.jitao.dubbodemo.api.service.PrivilegeService;
import tech.jitao.dubbodemo.bff.common.ApiResult;
import tech.jitao.dubbodemo.bff.common.dto.ListDto;

import java.util.List;

@RestController(ListPrivileges.PATH)
@CrossOrigin
public class ListPrivileges {
    static final String PATH = "/role/list-privileges";

    @Reference(version = "1.0.0")
    private PrivilegeService privilegeService;

    @PostMapping(PATH)
    public ApiResult process() {
        List<Privilege> privileges = privilegeService.listPrivileges();
        if (privileges.isEmpty()) {
            return ApiResult.okWithData(ListDto.empty());
        }

        return ApiResult.okWithData(ListDto.of(privileges));
    }
}
