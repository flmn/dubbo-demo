package tech.jitao.dubbodemo.bff.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import tech.jitao.dubbodemo.api.domain.Privilege;
import tech.jitao.dubbodemo.api.domain.Role;
import tech.jitao.dubbodemo.bff.common.dto.AuditDto;

import java.util.List;

public class RoleDto {
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer id;
    private String name;
    private String description;

    private List<Privilege> privileges;

    private AuditDto audit;

    public RoleDto() {
    }

    public RoleDto(Role m) {
        id = m.getId();
        name = m.getName();
        description = m.getDescription();
        privileges = m.getPrivileges();
        audit = new AuditDto(m);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }

    public AuditDto getAudit() {
        return audit;
    }

    public void setAudit(AuditDto audit) {
        this.audit = audit;
    }
}
