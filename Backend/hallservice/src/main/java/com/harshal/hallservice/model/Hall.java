package com.harshal.hallservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hallId;
    private String name;
    private String location;
    private int capacity;
    private double price;
    
    //Constructors
    
    public Hall() {}
    
    
    
 public Hall(Long hallId, String name, String location, int capacity, double price) {
		super();
		this.hallId = hallId;
		this.name = name;
		this.location = location;
		this.capacity = capacity;
		this.price = price;
	}



// Getters and Setters
	public Long getId() {
		return hallId;
	}
	public void setId(Long hallId) {
		this.hallId = hallId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

    
    
}
