package com.harshal.bookingservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private Long hallId;
    private Long userId;
    private Date bookingDate;
    private String status;
    
    //Constructors
    
    public Booking() {}
    
    public Booking(Long bookingId, Long hallId, Long userId, Date bookingDate, String status) {
		super();
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
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

    
   
}
