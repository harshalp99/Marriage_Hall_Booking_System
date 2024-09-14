package com.harshal.userservice.service;

import com.harshal.userservice.dto.BookingDTO;
import com.harshal.userservice.dto.ReviewDTO;
import com.harshal.userservice.feign.BookingFeignClient;
import com.harshal.userservice.feign.ReviewFeignClient;
import com.harshal.userservice.model.User;
import com.harshal.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Injecting Feign Clients
    @Autowired
    private BookingFeignClient bookingFeignClient;

    @Autowired
    private ReviewFeignClient reviewFeignClient;

    // User-related methods
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public boolean checkPassword(User user, String rawPassword) {
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }

    public User updateUser(Long userId, User userDetails) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        if (userDetails.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        }
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    // Fetch all bookings for a specific user using BookingFeignClient
    public List<BookingDTO> getBookingsByUserId(Long userId) {
        return bookingFeignClient.getBookingsByUserId(userId);
    }

    // Fetch all reviews for a specific user using ReviewFeignClient
    public List<ReviewDTO> getReviewsByUserId(Long userId) {
        return reviewFeignClient.getReviewsByUserId(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return new org.springframework.security.core.userdetails.User(
                user.get().getUsername(), user.get().getPassword(), new ArrayList<>());
    }
}
