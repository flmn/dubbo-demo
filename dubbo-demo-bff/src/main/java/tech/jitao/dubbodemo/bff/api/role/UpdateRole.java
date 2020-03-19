package tech.jitao.dubbodemo.bff.api.role;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.jitao.dubbodemo.api.domain.Privilege;
import tech.jitao.dubbodemo.api.domain.Role;
import tech.jitao.dubbodemo.api.service.RoleService;
import tech.jitao.dubbodemo.bff.common.ApiResult;
import tech.jitao.dubbodemo.bff.common.request.IntegerIdRequest;
import tech.jitao.dubbodemo.bff.config.RequestAttributes;
import tech.jitao.dubbodemo.bff.dto.RoleDto;

import javax.validation.constraints.Size;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController(UpdateRole.PATH)
@CrossOrigin
public class UpdateRole {
    static final String PATH = "/role/update-role";

    @Reference(version = "1.0.0")
    private RoleService roleService;

    @PostMapping(PATH)
    public ApiResult process(@Validated @RequestBody Request request,
                             @RequestAttribute(RequestAttributes.STAFF_ID) long staffId) {
        Role role = new Role();
        role.setName(request.getName());
        role.setDescription(request.getDescription());
        role.setPrivileges(request.getPrivileges().stream().map(p -> {
            Privilege privilege = new Privilege();
            privilege.setId(p);

            return privilege;
        }).collect(Collectors.toList()));
        role.setUpdateStaff(staffId);

        return ApiResult.okWithData(new RoleDto(roleService.updateRole(role)));
    }

    private static class Request extends IntegerIdRequest {

        @Size(max = 16)
        private String name;

        @Size(max = 255)
        private String description;

        private List<String> privileges = Collections.emptyList();

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<String> getPrivileges() {
            return privileges;
        }

        public void setPrivileges(List<String> privileges) {
            this.privileges = privileges;
        }
    }
}
