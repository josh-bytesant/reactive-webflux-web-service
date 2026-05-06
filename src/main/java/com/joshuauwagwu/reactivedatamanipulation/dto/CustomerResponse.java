package com.joshuauwagwu.reactivedatamanipulation.dto;

public class CustomerResponse {
    private String customerCode;
    private String oldCustomerCode;
    private String customerName;
    private String region;
    private String customerAddress;

    public CustomerResponse() {}
    public CustomerResponse(String customerCode, String oldCustomerCode, String customerName,
                               String region, String customerAddress) {
        this.customerCode = customerCode;
        this.oldCustomerCode = oldCustomerCode;
        this.customerName = customerName;
        this.region = region;
        this.customerAddress = customerAddress;

    }

    public String getCustomerCode() {
        return customerCode;
    }
    public String getOldCustomerCode()
    {
        return oldCustomerCode;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getRegion()
    {
        return region;
    }
    public String getCustomerAddress() {
        return customerAddress;
    }
}
