package com.harshal.hallservice.feign;

import com.harshal.hallservice.dto.BookingDTO;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "bookingservice", url = "http://localhost:8082")
public interface BookingFeignClient {

    // Get Booking by ID
    @GetMapping("/api/bookings/{bookingId}")
    BookingDTO getBookingById(@PathVariable Long bookingId);

    // Get Bookings by Hall ID
    @GetMapping("/api/bookings/hall/{hallId}")
    List<BookingDTO> getBookingsByHallId(@PathVariable Long hallId);
}
