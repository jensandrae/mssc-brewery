package com.springframework.msscbrewery.services;

import com.springframework.msscbrewery.web.model.CustomerDto;
import java.util.UUID;

/**
 * Created by Jens Andrae on 2020-10-15
 */
public interface CustomerService {

    CustomerDto getCustomerById(UUID customerId);

    CustomerDto saveNewCustomer(CustomerDto customerDto);

    void updateCustomer(UUID cusomterId, CustomerDto customerDto);

    void deleteById(UUID customerId);
}
