package com.harshal.bookingservice.dto;

import java.time.LocalDate;

public class BookingDTO {

    private Long bookingId;
    private Long hallId;
    private Long userId;
    private LocalDate bookingDate;
    private String status;

    // Constructors
    public BookingDTO() {}

    public BookingDTO(Long bookingId, Long hallId, Long userId, LocalDate bookingDate, String status) {
        this.bookingId = bookingId;
        this.hallId = hallId;
        this.userId = userId;
        this.bookingDate = bookingDate;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() {
        return bookingId;
    }

    public void setId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getHallId() {
        return hallId;
    }

    public void setHallId(Long hallId) {
        this.hallId = hallId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
