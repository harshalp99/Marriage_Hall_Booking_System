package com.harshal.hallservice.controller;

import com.harshal.hallservice.model.Hall;
import com.harshal.hallservice.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/halls")
public class HallController {
    @Autowired
    private HallService hallService;

    @GetMapping
    public List<Hall> getAllHalls() {
        return hallService.getAllHalls();
    }

    @PostMapping
    public Hall saveHall(@RequestBody Hall hall) {
        return hallService.saveHall(hall);
    }

    // Additional endpoints for CRUD operations
}
