package com.joshuauwagwu.reactivedatamanipulation.controller;

import com.joshuauwagwu.reactivedatamanipulation.dto.CustomerResponse;
import com.joshuauwagwu.reactivedatamanipulation.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
     }

     @GetMapping("/api/v1/customer/{customerCode}")
    public Mono<CustomerResponse> getCustomer(@PathVariable String customerCode) {
        return customerService.getCustomer(customerCode);
     }

}
