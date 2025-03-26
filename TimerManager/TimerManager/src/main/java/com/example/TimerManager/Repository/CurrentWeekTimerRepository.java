package com.example.TimerManager.Repository;

import com.example.TimerManager.Model.CurrentWeekTimer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentWeekTimerRepository extends JpaRepository<CurrentWeekTimer, Long> {
    CurrentWeekTimer findByUsername(String username);
}
