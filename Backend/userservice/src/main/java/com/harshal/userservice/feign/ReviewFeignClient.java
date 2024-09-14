package com.harshal.userservice.feign;

import com.harshal.userservice.dto.ReviewDTO;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "reviewservice", url = "http://localhost:8083")
public interface ReviewFeignClient {

    // Get Review by Hall ID
    @GetMapping("/api/reviews/hall/{hallId}")
    List<ReviewDTO> getReviewsByHallId(@PathVariable Long hallId);
    
 // Get Review by User ID
    @GetMapping("/api/reviews/user/{userId}")
    List<ReviewDTO> getReviewsByUserId(@PathVariable Long userId);
}
