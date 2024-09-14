package com.harshal.bookingservice.feign;

import com.harshal.bookingservice.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "userservice", url = "http://localhost:8084")
public interface UserFeignClient {

    // Get User by ID
    @GetMapping("/api/users/{userId}")
    UserDTO getUserById(@PathVariable Long userId);
}
