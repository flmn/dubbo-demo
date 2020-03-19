package tech.jitao.dubbodemo.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.jitao.dubbodemo.service.entity.StaffEntity;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<StaffEntity, Long> {
    Optional<StaffEntity> findByUsername(String username);
}
