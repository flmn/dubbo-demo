package tech.jitao.dubbodemo.bff.api.role;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.jitao.dubbodemo.api.domain.Role;
import tech.jitao.dubbodemo.api.dto.ListResponse;
import tech.jitao.dubbodemo.api.service.RoleService;
import tech.jitao.dubbodemo.bff.common.ApiResult;
import tech.jitao.dubbodemo.bff.common.dto.PageDto;
import tech.jitao.dubbodemo.bff.common.request.SearchingRequest;
import tech.jitao.dubbodemo.bff.dto.RoleDto;

import java.util.List;
import java.util.stream.Collectors;

@RestController(ListRoles.PATH)
@CrossOrigin
public class ListRoles {
    static final String PATH = "/role/list-roles";

    @Reference(version = "1.0.0")
    private RoleService roleService;

    @PostMapping(PATH)
    public ApiResult process(@Validated @RequestBody SearchingRequest request) {
        ListResponse<Role> response = roleService.listRoles(request.toCommonListRequest());
        if (response.getItems().isEmpty()) {
            return ApiResult.okWithData(PageDto.empty());
        }

        List<RoleDto> items = response.getItems().stream().map(RoleDto::new).collect(Collectors.toList());

        PageDto<RoleDto> dto = PageDto.of(items);
        dto.setTotal(response.getTotal());

        return ApiResult.okWithData(dto);
    }
}
