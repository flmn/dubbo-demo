package tech.jitao.dubbodemo.api.domain;

import java.io.Serializable;
import java.util.List;

public class Role extends Audit implements Serializable {
    private static final long serialVersionUID = -1460089072460097148L;

    private Integer id;
    private String name;
    private String description;

    List<Privilege> privileges;

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
}
