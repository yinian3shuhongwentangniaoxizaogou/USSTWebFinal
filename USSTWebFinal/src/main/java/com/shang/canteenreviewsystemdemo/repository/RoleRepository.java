package com.shang.canteenreviewsystemdemo.repository;

import com.shang.canteenreviewsystemdemo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
