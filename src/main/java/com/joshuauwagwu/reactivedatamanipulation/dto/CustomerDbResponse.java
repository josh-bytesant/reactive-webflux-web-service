package com.joshuauwagwu.reactivedatamanipulation.dto;

public class CustomerDbResponse {
    private String customerCode;
    private String legacyCustomerCode;
    private String customerName;
    private String region;
    private String address;

    public CustomerDbResponse() {}
    public CustomerDbResponse(String customerCode, String legacyCustomerCode, String customerName,
                              String region, String address) {
        this.customerCode = customerCode;
        this.legacyCustomerCode = legacyCustomerCode;
        this.customerName = customerName;
        this.region = region;
        this.address = address;

    }

    public String getCustomerCode() {
        return customerCode;
    }
    public String getLegacyCustomerCode()
    {
        return legacyCustomerCode;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getRegion()
    {
        return region;
    }
    public String getAddress() {
        return address;
    }
}
