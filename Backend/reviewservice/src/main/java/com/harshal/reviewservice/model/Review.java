package com.harshal.reviewservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    private Long hallId;
    private Long userId;
    private String comment;
    private int rating;
    
    //Constructors
    
    public Review() {}
    
    
    
    public Review(Long reviewId, Long hallId, Long userId, String comment, int rating) {
		super();
		this.reviewId = reviewId;
		this.hallId = hallId;
		this.userId = userId;
		this.comment = comment;
		this.rating = rating;
	}



	// Getters and Setters
    
	public Long getId() {
		return reviewId;
	}
	public void setId(Long reviewId) {
		this.reviewId = reviewId;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}

  
    
}
