package com.example.trainbooking.TrainBookingApplication.Controller;


import com.example.trainbooking.TrainBookingApplication.Services.BookingService;
import com.example.trainbooking.TrainBookingApplication.model.Ticket;
import com.example.trainbooking.TrainBookingApplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/purchase")
    public User purchaseTicket(@RequestBody Map<String, String> request) {
        String from = request.get("from");
        String to = request.get("to");
        String firstName = request.get("firstName");
        String lastName = request.get("lastName");
        String email = request.get("email");
        // Allocate seat logic (simplified for example)
        String seat = Math.random() > 0.5 ? "A" : "B";
        return bookingService.purchaseTicket(from, to, firstName, lastName, email, seat);
    }

    @GetMapping("/receipt/{userId}")
    public Ticket getReceipt(@PathVariable Long userId) {
        return bookingService.getReceipt(userId);
    }

    @GetMapping("/users/section/{section}")
    public List<User> getUsersBySection(@PathVariable String section) {
        return bookingService.getUsersBySection(section);
    }

    @DeleteMapping("/user/{userId}")
    public void removeUser(@PathVariable Long userId) {
        bookingService.removeUser(userId);
    }

    @PutMapping("/user/{userId}/seat")
    public User modifySeat(@PathVariable Long userId, @RequestParam String newSeat) {
        return bookingService.modifySeat(userId, newSeat);
    }
}