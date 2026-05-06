package com.joshuauwagwu.reactivedatamanipulation.dto;

import java.util.ArrayList;
import java.util.List;

public class CustomerSAPRequest {
    private CustomerMaster CustomerMaster;

    public CustomerSAPRequest() {}
    public CustomerSAPRequest(CustomerMaster CustomerMaster) {
        this.CustomerMaster = CustomerMaster;
    }
    public CustomerMaster getCustomerMaster() {
        return CustomerMaster;
    }


    public static class CustomerMaster {

        private List<Customer> customer;

        public CustomerMaster() {}

        public CustomerMaster(List<Customer> customer) {
            this.customer = customer;
        }

        public List<Customer> getCustomer() {
            return customer;
        }
    }

    public static class Customer {

        private String customerNos;
        private String legacyCustomerNos;

        public Customer() {}

        public Customer(String customerNos, String legacyCustomerNos) {
            this.customerNos = customerNos;
            this.legacyCustomerNos = legacyCustomerNos;
        }

        public String getCustomerNos() {
            return customerNos;
        }

        public String getLegacyCustomerNos() {
            return legacyCustomerNos;
        }
    }
}







