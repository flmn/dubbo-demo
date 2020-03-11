package tech.jitao.dubbodemo.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.jitao.dubbodemo.service.entity.StaffEntity;

public interface StaffRepository extends JpaRepository<StaffEntity, Long> {
}
