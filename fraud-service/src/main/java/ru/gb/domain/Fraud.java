package ru.gb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fraud {
    private Integer id;
    private Integer customerId;
    private Boolean isFraudster;
    private final LocalDateTime recordCreated = LocalDateTime.now();
}
