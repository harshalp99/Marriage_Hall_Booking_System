package com.harshal.hallservice.controller;

import com.harshal.hallservice.model.Hall;
import com.harshal.hallservice.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/halls")
public class HallController {
	
    @Autowired
    private HallService hallService;

    // Get all halls
    @GetMapping
    public List<Hall> getAllHalls() {
        return hallService.getAllHalls();
    }

    // Get hall by ID
    @GetMapping("/{hallId}")
    public Optional<Hall> getHallById(@PathVariable Long hallId) {
        return hallService.getHallById(hallId);
    }

    // Add a new hall
    @PostMapping
    public Hall createHall(@RequestBody Hall hall) {
        return hallService.createHall(hall);
    }

    // Update a hall
    @PutMapping("/{hallId}")
    public Hall updateHall(@PathVariable Long hallId, @RequestBody Hall hallDetails) {
        return hallService.updateHall(hallId, hallDetails);
    }

    // Delete a hall
    @DeleteMapping("/{hallId}")
    public void deleteHall(@PathVariable Long hallId) {
        hallService.deleteHall(hallId);
    }
}