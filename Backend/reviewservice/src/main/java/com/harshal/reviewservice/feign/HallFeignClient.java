package com.harshal.reviewservice.feign;

import com.harshal.reviewservice.dto.HallDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "hallservice", url = "http://localhost:8081")
public interface HallFeignClient {

    // Get Hall by ID
    @GetMapping("/api/halls/{hallId}")
    HallDTO getHallById(@PathVariable Long hallId);
}
