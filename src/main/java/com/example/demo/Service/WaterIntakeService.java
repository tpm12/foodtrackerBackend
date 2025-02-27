package com.example.demo.Service;

import com.example.demo.Models.WaterIntake;
import com.example.demo.Repo.WaterIntakeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WaterIntakeService {
    private final WaterIntakeRepository waterIntakeRepository;

    public WaterIntakeService(WaterIntakeRepository waterIntakeRepository) {
        this.waterIntakeRepository = waterIntakeRepository;
    }

    public WaterIntake logWaterIntake(WaterIntake intake) {
        return waterIntakeRepository.save(intake);
    }

    public List<WaterIntake> getUserWaterIntake(Long userId) {
        return waterIntakeRepository.findByUserId(userId);
    }

    public Optional<WaterIntake> getWaterIntakeById(Long id) {
        return waterIntakeRepository.findById(id);
    }

    public WaterIntake updateWaterIntake(Long id, WaterIntake updatedIntake) {
        Optional<WaterIntake> existingIntake = waterIntakeRepository.findById(id);
        if (existingIntake.isPresent()) {
            WaterIntake waterIntake = existingIntake.get();
            waterIntake.setAmount(updatedIntake.getAmount());
            return waterIntakeRepository.save(waterIntake);
        }
        return null;
    }

    public boolean deleteWaterIntake(Long id) {
        if (waterIntakeRepository.existsById(id)) {
            waterIntakeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

