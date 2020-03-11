package tech.jitao.dubbodemo.service.entity;


import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AuditableEntity extends VersionedEntity {

    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;

    @Column(name = "create_staff", nullable = false)
    private Long createStaff = 0L;

    @Column(name = "update_time", nullable = false)
    private LocalDateTime updateTime;

    @Column(name = "update_staff", nullable = false)
    private Long updateStaff = 0L;

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Long getCreateStaff() {
        return createStaff;
    }

    public void setCreateStaff(Long createStaff) {
        this.createStaff = createStaff;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateStaff() {
        return updateStaff;
    }

    public void setUpdateStaff(Long updateStaff) {
        this.updateStaff = updateStaff;
    }
}
