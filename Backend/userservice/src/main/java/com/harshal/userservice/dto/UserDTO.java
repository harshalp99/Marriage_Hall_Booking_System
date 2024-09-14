package com.harshal.userservice.dto;

public class UserDTO {

    private Long userId;
    private String name;
    private String email;

    // Constructors
    public UserDTO() {}

    public UserDTO(Long userId, String name, String email, String phoneNumber) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() {
        return userId;
    }

    public void setId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
