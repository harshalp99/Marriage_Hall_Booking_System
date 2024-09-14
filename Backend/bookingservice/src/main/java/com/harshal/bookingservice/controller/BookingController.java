package com.harshal.bookingservice.controller;

import com.harshal.bookingservice.model.Booking;
import com.harshal.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Get all bookings
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    // Get booking by ID
    @GetMapping("/{bookingId}")
    public Booking getBookingById(@PathVariable Long bookingId) {
        return bookingService.getBookingById(bookingId);
    }

    // Add a new booking
    @PostMapping
    public Booking addBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    // Update a booking
    @PutMapping("/{bookingId}")
    public Booking updateBooking(@PathVariable Long bookingId, @RequestBody Booking bookingDetails) {
        return bookingService.updateBooking(bookingId, bookingDetails);
    }

    // Delete a booking
    @DeleteMapping("/{bookingId}")
    public void deleteBooking(@PathVariable Long bookingId) {
        bookingService.deleteBooking(bookingId);
    }
}
