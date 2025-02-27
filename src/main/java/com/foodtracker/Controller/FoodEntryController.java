package com.foodtracker.Controller;

import com.foodtracker.Models.FoodEntry;
import com.foodtracker.Service.FoodEntryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/food")
public class FoodEntryController {
    private final FoodEntryService foodEntryService;

    public FoodEntryController(FoodEntryService foodEntryService) {
        this.foodEntryService = foodEntryService;
    }

    @PostMapping
    public ResponseEntity<FoodEntry> addFoodEntry(@RequestBody FoodEntry foodEntry) {
        return ResponseEntity.ok(foodEntryService.addFoodEntry(foodEntry));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<FoodEntry>> getUserFoodEntries(@PathVariable Long userId) {
        return ResponseEntity.ok(foodEntryService.getUserFoodEntries(userId));
    }

    @GetMapping("/entry/{id}")
    public ResponseEntity<FoodEntry> getFoodEntryById(@PathVariable Long id) {
        Optional<FoodEntry> entry = foodEntryService.getFoodEntryById(id);
        return entry.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodEntry> updateFoodEntry(@PathVariable Long id, @RequestBody FoodEntry updatedEntry) {
        FoodEntry foodEntry = foodEntryService.updateFoodEntry(id, updatedEntry);
        return foodEntry != null ? ResponseEntity.ok(foodEntry) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoodEntry(@PathVariable Long id) {
        return foodEntryService.deleteFoodEntry(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

