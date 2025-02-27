package com.foodtracker.Controller;

import com.foodtracker.Models.WaterIntake;
import com.foodtracker.Service.WaterIntakeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/water")
public class WaterIntakeController {
    private final WaterIntakeService waterIntakeService;

    public WaterIntakeController(WaterIntakeService waterIntakeService) {
        this.waterIntakeService = waterIntakeService;
    }

    @PostMapping
    public ResponseEntity<WaterIntake> logWaterIntake(@RequestBody WaterIntake intake) {
        return ResponseEntity.ok(waterIntakeService.logWaterIntake(intake));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<WaterIntake>> getUserWaterIntake(@PathVariable Long userId) {
        return ResponseEntity.ok(waterIntakeService.getUserWaterIntake(userId));
    }

    @GetMapping("/entry/{id}")
    public ResponseEntity<WaterIntake> getWaterIntakeById(@PathVariable Long id) {
        Optional<WaterIntake> entry = waterIntakeService.getWaterIntakeById(id);
        return entry.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<WaterIntake> updateWaterIntake(@PathVariable Long id, @RequestBody WaterIntake updatedIntake) {
        WaterIntake waterIntake = waterIntakeService.updateWaterIntake(id, updatedIntake);
        return waterIntake != null ? ResponseEntity.ok(waterIntake) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWaterIntake(@PathVariable Long id) {
        return waterIntakeService.deleteWaterIntake(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
