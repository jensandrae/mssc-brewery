package com.springframework.msscbrewery.services;

import com.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.UUID;

/**
 * Created by Jens Andrae on 2020-10-15
 */
@Slf4j  // Lombok logging
@Service
public class CustomerServiceImpl implements CustomerService{

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .customerName("Joe Buck")
                .build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return new CustomerDto().builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        // ToDo: Implement
        log.debug("Updating a customer...");
    }

    @Override
    public void deleteById(UUID customerId) {
        log.debug("Deleting a customer...");
    }
}
