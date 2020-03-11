package tech.jitao.dubbodemo.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.jitao.dubbodemo.service.entity.PrivilegeEntity;

public interface PrivilegeRepository extends JpaRepository<PrivilegeEntity, String> {
}
