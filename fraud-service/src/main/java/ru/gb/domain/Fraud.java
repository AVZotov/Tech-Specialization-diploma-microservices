package ru.gb.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Fraud {

    @Id
    @SequenceGenerator(
            name = "fraud_id_history",
            sequenceName = "fraud_id_history",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fraud_id_history")
    private Integer id;
    private Integer customerId;
    private boolean isFraudster;
    private final LocalDateTime recordCreated = LocalDateTime.now();
}
