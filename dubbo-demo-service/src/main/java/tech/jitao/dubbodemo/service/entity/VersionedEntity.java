package tech.jitao.dubbodemo.service.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class VersionedEntity {

    @Version
    @Column(name = "version", nullable = false)
    protected Integer version;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
