package ru.gb.service;

import org.springframework.stereotype.Service;

@Service
public class FraudCheckService {
    public boolean isFraudulentCustomer(Integer ignoredCustomerId){
        return false;
    }
}
