package com.foodtracker.Repo;

import com.foodtracker.Models.FoodEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FoodEntryRepository extends JpaRepository<FoodEntry, Long> {
    List<FoodEntry> findByUserId(Long userId);
}

