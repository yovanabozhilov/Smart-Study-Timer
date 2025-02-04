package com.example.NewProject.Repository;

import com.example.NewProject.Model.Timer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimerRepository extends JpaRepository<Timer, Long> {
    Timer findByUserEmail(String userEmail);
}
