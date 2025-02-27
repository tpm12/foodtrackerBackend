package com.example.demo.Repo;

import com.example.demo.Models.WaterIntake;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WaterIntakeRepository extends JpaRepository<WaterIntake, Long> {
    List<WaterIntake> findByUserId(Long userId);
}

