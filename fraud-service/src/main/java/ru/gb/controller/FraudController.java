package ru.gb.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.service.FraudCheckService;
import ru.gb.utils.FraudCheckResponse;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/fraud-checks")
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
        log.info("Check request for customer {}", customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}


