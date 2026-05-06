package com.joshuauwagwu.reactivedatamanipulation.service;

import com.joshuauwagwu.reactivedatamanipulation.dto.*;
import com.joshuauwagwu.reactivedatamanipulation.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {
    public final WebClient webClient;
    public final CustomerRepository customerRepository;
    public CustomerService(WebClient.Builder webClientBuilder, CustomerRepository customerRepository) {
        this.webClient = webClientBuilder
                .baseUrl("https://sapgatewayws.sevenup.org")
                .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .build();
        this.customerRepository = customerRepository;
    }

    public Mono<CustomerResponse> getCustomer(String customerCode) {
        String normalizedCode = customerCode == null ? "" : customerCode.trim();
        CustomerSAPRequest.Customer customer = new CustomerSAPRequest.Customer(normalizedCode, "");

        CustomerSAPRequest.CustomerMaster customerMaster =
                new CustomerSAPRequest.CustomerMaster(List.of(customer));

        CustomerSAPRequest sapRequest = new CustomerSAPRequest(customerMaster);


// external call as a Mono (with error handling)
        Mono<CustomerSAPResponse> externalCall = webClient.post()
                .uri("/api/Customer/CustomerMaster")
                .bodyValue(sapRequest)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, resp ->
                        Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "External User Not Found")))
                .onStatus(HttpStatusCode::is5xxServerError, resp ->
                        Mono.error(new ResponseStatusException(HttpStatus.BAD_GATEWAY, "External Service Down")))
                .bodyToMono(CustomerSAPResponse.class);

        // DB call

        Mono<CustomerDbResponse> dbCustomer = Mono.from(customerRepository.findCustomerByCode(normalizedCode))
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found in DB")));

        // compose and return: do not subscribe here
        return Mono.zip(externalCall, dbCustomer)
                .map(tuple -> {
                    CustomerSAPResponse sapResponse = tuple.getT1();
                    CustomerDbResponse dbResponse = tuple.getT2();

                    var sapCustomer = sapResponse.getCustomerMaster_Res().getCustomerMaster().get(0);

                    return new CustomerResponse(
                            dbResponse.getCustomerCode(),
                            sapCustomer.getLegacyCustomerNos(),
                            dbResponse.getCustomerName(),
                            dbResponse.getRegion(),
                            sapCustomer.getAddress()
                    );
                });
    }
}
