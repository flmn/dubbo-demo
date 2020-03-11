package tech.jitao.dubbodemo.service.entity;

import tech.jitao.dubbodemo.api.domain.Role;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_role", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})
})
public class RoleEntity extends AuditableEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 32, nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description = "";

    @ManyToMany
    @JoinTable(name = "t_role_privilege", joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id"))
    private List<PrivilegeEntity> privileges;

    public Role toRole() {
        Role d = new Role();
        d.setId(id);
        d.setName(name);
        d.setDescription(description);

        return d;
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

    public List<PrivilegeEntity> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<PrivilegeEntity> privileges) {
        this.privileges = privileges;
    }
}
