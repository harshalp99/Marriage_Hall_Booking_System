package com.harshal.hallservice.service;

import com.harshal.hallservice.model.Hall;
import com.harshal.hallservice.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallService {
    @Autowired
    private HallRepository hallRepository;

    public List<Hall> getAllHalls() {
        return hallRepository.findAll();
    }

    public Hall saveHall(Hall hall) {
        return hallRepository.save(hall);
    }

    // Additional methods for business logic
}
