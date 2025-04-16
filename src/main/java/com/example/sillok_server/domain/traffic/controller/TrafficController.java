package com.example.sillok_server.domain.traffic.controller;

import com.example.sillok_server.domain.traffic.service.TrafficService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TrafficController {
    private final TrafficService trafficService;

    @GetMapping
    public void countVisit() {
        trafficService.visit();
    }
}
