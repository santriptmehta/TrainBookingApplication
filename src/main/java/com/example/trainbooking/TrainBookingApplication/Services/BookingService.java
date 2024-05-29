package com.example.trainbooking.TrainBookingApplication.Services;

import com.example.trainbooking.TrainBookingApplication.Repositories.UserRepository;
import com.example.trainbooking.TrainBookingApplication.model.Ticket;
import com.example.trainbooking.TrainBookingApplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User purchaseTicket(String from, String to, String firstName, String lastName, String email, String seat) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);

        Ticket ticket = new Ticket();
        ticket.setFromLocation(from);
        ticket.setToLocation(to);
        ticket.setPrice(20.0);
        ticket.setSeat(seat);

        user.setTicket(ticket);

        return userRepository.save(user);
    }

    public Ticket getReceipt(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.map(User::getTicket).orElse(null);
    }

    public List<User> getUsersBySection(String section) {
        return userRepository.findAll().stream()
                .filter(user -> user.getTicket().getSeat().startsWith(section))
                .toList();
    }

    public void removeUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User modifySeat(Long userId, String newSeat) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.getTicket().setSeat(newSeat);
            return userRepository.save(user);
        }
        return null;
    }
}