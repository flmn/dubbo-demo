package tech.jitao.dubbodemo.api.dto;

import tech.jitao.dubbodemo.api.domain.Staff;

import java.io.Serializable;
import java.util.Set;

public class AuthenticateResponse implements Serializable {
    private static final long serialVersionUID = 6392258817729208283L;

    private Staff staff; // staff
    private Set<String> privileges; // 权限列表

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Set<String> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<String> privileges) {
        this.privileges = privileges;
    }
}
