package com.example.trainbooking.TrainBookingApplication.Repositories;

import com.example.trainbooking.TrainBookingApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}