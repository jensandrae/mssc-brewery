package com.springframework.msscbrewery.services;

import com.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;
import java.util.UUID;

/**
 * Created by Jens Andrae on 2020-10-15
 */
@Service
public class CustomerServiceImpl implements CustomerService{

    @Override
    public CustomerDto getCustomer(UUID customerId) {
        return CustomerDto.builder()
                .id(customerId)
                .customerName("Joe Buck")
                .build();
    }
}
