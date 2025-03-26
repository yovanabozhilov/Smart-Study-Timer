package com.example.TimerManager.Repository;

import com.example.TimerManager.Model.CurrentDayTimer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentDayTimerRepository extends JpaRepository<CurrentDayTimer, Long> {
    CurrentDayTimer findByUsername(String username);
}
