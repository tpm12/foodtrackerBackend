package com.foodtracker.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Double dailyCalorieGoal;

    @Column(nullable = false)
    private Double dailyWaterGoal;

    public User() {}

    public User(String username, String password, Double dailyCalorieGoal, Double dailyWaterGoal) {
        this.username = username;
        this.password = password;
        this.dailyCalorieGoal = dailyCalorieGoal;
        this.dailyWaterGoal = dailyWaterGoal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getDailyCalorieGoal() {
        return dailyCalorieGoal;
    }

    public void setDailyCalorieGoal(Double dailyCalorieGoal) {
        this.dailyCalorieGoal = dailyCalorieGoal;
    }

    public Double getDailyWaterGoal() {
        return dailyWaterGoal;
    }

    public void setDailyWaterGoal(Double dailyWaterGoal) {
        this.dailyWaterGoal = dailyWaterGoal;
    }
}
