package com.example.sillok_server.domain.traffic.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Traffic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

    private int clickCount = 0;

    private int visitCount = 0;

    public void click() {
        clickCount++;
    }

    public void visit() {
        visitCount++;
    }
}
