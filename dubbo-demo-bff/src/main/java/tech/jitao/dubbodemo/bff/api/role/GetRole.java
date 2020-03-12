package tech.jitao.dubbodemo.bff.api.role;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.jitao.dubbodemo.api.exception.NotFoundException;
import tech.jitao.dubbodemo.api.service.RoleService;
import tech.jitao.dubbodemo.bff.common.ApiResult;
import tech.jitao.dubbodemo.bff.common.request.IntegerIdRequest;

@RestController(GetRole.PATH)
@CrossOrigin
public class GetRole {
    static final String PATH = "/role/get-role";

    @Reference(version = "1.0.0")
    private RoleService roleService;

    @PostMapping(PATH)
    public ApiResult process(@Validated @RequestBody IntegerIdRequest request) {
        try {
            return ApiResult.okWithData(roleService.getRole(request.getId()));
        } catch (NotFoundException e) {
            return ApiResult.error("找不到角色");
        }
    }
}
