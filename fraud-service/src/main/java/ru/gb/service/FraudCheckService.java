package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.domain.Fraud;
import ru.gb.repository.FraudChecksRepository;

@Service
@RequiredArgsConstructor
public class FraudCheckService {

    private final FraudChecksRepository fraudChecksRepository;

    public boolean isFraudulentCustomer(Integer customerId){
        fraudChecksRepository.save(
                Fraud
                        .builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .build()
        );

        return false;
    }
}
