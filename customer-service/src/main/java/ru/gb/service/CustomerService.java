package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.gb.configuration.RabbitMqMessageProducer;
import ru.gb.domain.Customer;
import ru.gb.domain.CustomerRegistrationRequest;
import ru.gb.fraud.FraudCheckResponse;
import ru.gb.fraud.FraudClient;
import ru.gb.notification.NotificationRequest;
import ru.gb.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final RabbitMqMessageProducer rabbitMqMessageProducer;

    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer
                .builder()
                .firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email())
                .build();

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("requested customer is fraudster");
        }

        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hello %s, welcome to notification service", customer.getFirstName())
        );

        rabbitMqMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );
    }
}
