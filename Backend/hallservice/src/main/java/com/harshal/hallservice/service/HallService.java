package com.harshal.hallservice.service;

import com.harshal.hallservice.dto.BookingDTO;
import com.harshal.hallservice.feign.BookingFeignClient;
import com.harshal.hallservice.model.Hall;
import com.harshal.hallservice.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HallService {

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private BookingFeignClient bookingFeignClient;

    // Create a new hall
    public Hall createHall(Hall hall) {
        return hallRepository.save(hall);
    }

    // Get all halls
    public List<Hall> getAllHalls() {
        return hallRepository.findAll();
    }

    // Get hall by ID
    public Optional<Hall> getHallById(Long hallId) {
        return hallRepository.findById(hallId);
    }

    // Update a hall
    public Hall updateHall(Long hallId, Hall hallDetails) {
        Hall hall = hallRepository.findById(hallId).orElseThrow(() -> new RuntimeException("Hall not found"));
        hall.setName(hallDetails.getName());
        hall.setLocation(hallDetails.getLocation());
        hall.setCapacity(hallDetails.getCapacity());
        hall.setPrice(hallDetails.getPrice());
        return hallRepository.save(hall);
    }

    // Delete a hall
    public void deleteHall(Long hallId) {
        hallRepository.deleteById(hallId);
    }

    // Get bookings for a hall by using BookingFeignClient
    public List<BookingDTO> getBookingsForHall(Long hallId) {
        return bookingFeignClient.getBookingsByHallId(hallId);
    }
}
