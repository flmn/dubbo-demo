package tech.jitao.dubbodemo.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.jitao.dubbodemo.service.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
}
