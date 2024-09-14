package com.harshal.bookingservice.feign;

import com.harshal.bookingservice.dto.ReviewDTO;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "reviewservice", url = "http://localhost:8083")
public interface ReviewFeignClient {

    // Get Review by Hall ID
    @GetMapping("/api/reviews/hall/{hallId}")
    List<ReviewDTO> getReviewsByHallId(@PathVariable Long hallId);
}
