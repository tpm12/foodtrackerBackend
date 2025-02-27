package com.foodtracker.Service;

import com.foodtracker.Models.FoodEntry;
import com.foodtracker.Repo.FoodEntryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FoodEntryService {
    private final FoodEntryRepository foodEntryRepository;

    public FoodEntryService(FoodEntryRepository foodEntryRepository) {
        this.foodEntryRepository = foodEntryRepository;
    }

    public FoodEntry addFoodEntry(FoodEntry entry) {
        return foodEntryRepository.save(entry);
    }

    public List<FoodEntry> getUserFoodEntries(Long userId) {
        return foodEntryRepository.findByUserId(userId);
    }

    public Optional<FoodEntry> getFoodEntryById(Long id) {
        return foodEntryRepository.findById(id);
    }

    public FoodEntry updateFoodEntry(Long id, FoodEntry updatedEntry) {
        Optional<FoodEntry> existingEntry = foodEntryRepository.findById(id);
        if (existingEntry.isPresent()) {
            FoodEntry foodEntry = existingEntry.get();
            foodEntry.setFoodName(updatedEntry.getFoodName());
            foodEntry.setCalories(updatedEntry.getCalories());
            foodEntry.setProtein(updatedEntry.getProtein());
            foodEntry.setCarbs(updatedEntry.getCarbs());
            foodEntry.setFats(updatedEntry.getFats());
            return foodEntryRepository.save(foodEntry);
        }
        return null;
    }

    // Delete a food entry by ID
    public boolean deleteFoodEntry(Long id) {
        if (foodEntryRepository.existsById(id)) {
            foodEntryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

