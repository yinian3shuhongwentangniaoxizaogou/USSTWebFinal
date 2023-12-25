package com.shang.canteenreviewsystemdemo.repository;

import com.shang.canteenreviewsystemdemo.model.Canteen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanteenRepository extends JpaRepository<Canteen, Long> {

}
