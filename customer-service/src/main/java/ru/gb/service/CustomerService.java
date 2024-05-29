package ru.gb.service;

import org.springframework.stereotype.Service;
import ru.gb.domain.Customer;
import ru.gb.domain.CustomerRegistrationRequest;

@Service
public class CustomerService {

    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest){
        Customer customer = Customer
                .builder()
                .firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email())
                .build();
        //todo: Save customer in Database
    }
}
