package com.springframework.msscbrewery.web.mappers;

import com.springframework.msscbrewery.domain.Customer;
import com.springframework.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

/**
 * Created by Jens Andrae on 2020-10-27
 */
@Mapper
public interface CustomerMapper {

    Customer CustomerDtoToCustomer(CustomerDto customerDto);

    CustomerDto CustomerToCustomerDto(Customer customer);
}
