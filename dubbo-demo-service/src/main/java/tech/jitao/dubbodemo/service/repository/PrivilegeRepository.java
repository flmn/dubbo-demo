package tech.jitao.dubbodemo.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.jitao.dubbodemo.service.entity.PrivilegeEntity;

import java.util.List;

public interface PrivilegeRepository extends JpaRepository<PrivilegeEntity, String> {

    List<PrivilegeEntity> findAllByOrderBySortOrderDesc();
}
