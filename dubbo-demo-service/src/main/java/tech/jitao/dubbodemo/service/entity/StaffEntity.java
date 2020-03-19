package tech.jitao.dubbodemo.service.entity;

import tech.jitao.dubbodemo.api.domain.Staff;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "t_staff")
public class StaffEntity extends AuditableEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 16, nullable = false)
    private String username;

    @Column(name = "password", length = 64, nullable = false)
    private String password;

    @Column(name = "screen_name", length = 16, nullable = false)
    private String screenName;

    @Column(name = "avatar", length = 128, nullable = false)
    private String avatar;

    @Column(name = "is_locked", nullable = false)
    private String isLocked;

    @Column(name = "last_login_time")
    private LocalDateTime lastLoginTime;

    @ManyToMany
    @JoinTable(name = "t_staff_role", joinColumns = @JoinColumn(name = "staff_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles;

    public Staff toStaff() {
        Staff d = new Staff();
        d.setId(id);
        d.setUsername(username);
        d.setScreenName(screenName);
        d.setAvatar(avatar);
        d.setIsLocked(isLocked);
        d.setLastLoginTime(lastLoginTime);

        return d;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(String isLocked) {
        this.isLocked = isLocked;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }
}
