package com.springframework.msscbrewery.web.controller;

import com.springframework.msscbrewery.services.CustomerService;
import com.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by Jens Andrae on 2020-10-15
 */
@RequestMapping("/customer/api/v1/")
@RestController
public class CustomerController {

    /**
     * TODO: Implement...
     * POST     - CREATE
     * PUT      - UPDATE
     * DELETE   - DELETE
     *
     */

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto) {
        CustomerDto savedDto = customerService.saveNewCustomer(customerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        // ToDo: Add hostname to url
        httpHeaders.add("Location", "/api/v1/customer" + savedDto.getId().toString());
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{cusomterId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@PathVariable("cusomterId") UUID customerId, @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerId, customerDto);
    }

    @DeleteMapping("/{cusomterId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("cusomterId")UUID customerId) {
        customerService.deleteById(customerId);
    }


}
