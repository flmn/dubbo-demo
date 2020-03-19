package tech.jitao.dubbodemo.bff.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import tech.jitao.dubbodemo.api.domain.Audit;

import java.time.LocalDateTime;

public class AuditDto {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    private Long createStaff;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    private Long updateStaff;

    public AuditDto() {
    }

    public AuditDto(Audit m) {
        createTime = m.getCreateTime();
        createStaff = m.getCreateStaff();
        updateTime = m.getUpdateTime();
        updateStaff = m.getUpdateStaff();
    }

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
