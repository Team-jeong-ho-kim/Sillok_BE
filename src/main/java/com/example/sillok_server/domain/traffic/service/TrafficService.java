package com.example.sillok_server.domain.traffic.service;

import com.example.sillok_server.domain.traffic.domain.Traffic;
import com.example.sillok_server.domain.traffic.domain.repository.TrafficRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrafficService {
    private final TrafficRepository trafficRepository;

    @Transactional
    public void visit() {
        Traffic traffic = trafficRepository.findById(1L)
                .orElseGet(() -> {
                    Traffic newTraffic = new Traffic();
                    return trafficRepository.save(newTraffic);
                });
        traffic.visit();
    }

    @Transactional
    public void click() {
        Traffic traffic = trafficRepository.findById(1L)
                .orElseGet(() -> {
                    Traffic newTraffic = new Traffic();
                    return trafficRepository.save(newTraffic);
                });

        traffic.click();
    }
}
