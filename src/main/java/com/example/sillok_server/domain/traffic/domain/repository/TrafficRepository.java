package com.example.sillok_server.domain.traffic.domain.repository;

import com.example.sillok_server.domain.traffic.domain.Traffic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrafficRepository extends JpaRepository<Traffic, Long> {
}
