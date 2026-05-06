package com.joshuauwagwu.reactivedatamanipulation.dto;

import java.util.List;

public class CustomerSAPResponse {
    private CustomerMasterRes customerMaster_Res;

    public CustomerSAPResponse() {}

    public CustomerSAPResponse(CustomerMasterRes customerMaster_Res) {
        this.customerMaster_Res = customerMaster_Res;
    }

    public CustomerMasterRes getCustomerMaster_Res() {
        return customerMaster_Res;
    }

    public static class CustomerMasterRes {

        private List<CustomerMaster> customerMaster;

        public CustomerMasterRes() {}

        public CustomerMasterRes(List<CustomerMaster> customerMaster) {
            this.customerMaster = customerMaster;
        }

        public List<CustomerMaster> getCustomerMaster() {
            return customerMaster;
        }
    }

    public static class CustomerMaster {

        private String customerNos;
        private String legacyCustomerNos;
        private String customerDescription;
        private String distributionChannel;
        private String division;
        private String salesOrganization;
        private String customerAccountGroup;
        private String plant;
        private String address;
        private String emailAddress;
        private String telephoneNo1;
        private String telephoneNo2;
        private String customerType;
        private String customerTypeDesc;
        private String salesOffice;
        private String salesGroup;
        private String isCustomerBlocked;

        private List<ShipToParty> shiptoParty;
        private List<CreditCustomer> credit_Customers;
        private List<CreditArea> credit_Areas;

        public CustomerMaster() {}

        public CustomerMaster(
                String customerNos,
                String legacyCustomerNos,
                String customerDescription,
                String distributionChannel,
                String division,
                String salesOrganization,
                String customerAccountGroup,
                String plant,
                String address,
                String emailAddress,
                String telephoneNo1,
                String telephoneNo2,
                String customerType,
                String customerTypeDesc,
                String salesOffice,
                String salesGroup,
                String isCustomerBlocked,
                List<ShipToParty> shiptoParty,
                List<CreditCustomer> credit_Customers,
                List<CreditArea> credit_Areas
        ) {
            this.customerNos = customerNos;
            this.legacyCustomerNos = legacyCustomerNos;
            this.customerDescription = customerDescription;
            this.distributionChannel = distributionChannel;
            this.division = division;
            this.salesOrganization = salesOrganization;
            this.customerAccountGroup = customerAccountGroup;
            this.plant = plant;
            this.address = address;
            this.emailAddress = emailAddress;
            this.telephoneNo1 = telephoneNo1;
            this.telephoneNo2 = telephoneNo2;
            this.customerType = customerType;
            this.customerTypeDesc = customerTypeDesc;
            this.salesOffice = salesOffice;
            this.salesGroup = salesGroup;
            this.isCustomerBlocked = isCustomerBlocked;
            this.shiptoParty = shiptoParty;
            this.credit_Customers = credit_Customers;
            this.credit_Areas = credit_Areas;
        }

        public String getCustomerNos() { return customerNos; }
        public String getLegacyCustomerNos() { return legacyCustomerNos; }
        public String getCustomerDescription() { return customerDescription; }
        public String getDistributionChannel() { return distributionChannel; }
        public String getDivision() { return division; }
        public String getSalesOrganization() { return salesOrganization; }
        public String getCustomerAccountGroup() { return customerAccountGroup; }
        public String getPlant() { return plant; }
        public String getAddress() { return address; }
        public String getEmailAddress() { return emailAddress; }
        public String getTelephoneNo1() { return telephoneNo1; }
        public String getTelephoneNo2() { return telephoneNo2; }
        public String getCustomerType() { return customerType; }
        public String getCustomerTypeDesc() { return customerTypeDesc; }
        public String getSalesOffice() { return salesOffice; }
        public String getSalesGroup() { return salesGroup; }
        public String getIsCustomerBlocked() { return isCustomerBlocked; }

        public List<ShipToParty> getShiptoParty() { return shiptoParty; }
        public List<CreditCustomer> getCredit_Customers() { return credit_Customers; }
        public List<CreditArea> getCredit_Areas() { return credit_Areas; }
    }

    public static class ShipToParty {

        private String legacyCustomerNos;
        private String customerDescription;
        private String salesOrganization;
        private String address;
        private String emailAddress;
        private String telephoneNo1;
        private String plant;

        public ShipToParty() {}

        public ShipToParty(String legacyCustomerNos, String customerDescription,
                           String salesOrganization, String address,
                           String emailAddress, String telephoneNo1,
                           String plant) {
            this.legacyCustomerNos = legacyCustomerNos;
            this.customerDescription = customerDescription;
            this.salesOrganization = salesOrganization;
            this.address = address;
            this.emailAddress = emailAddress;
            this.telephoneNo1 = telephoneNo1;
            this.plant = plant;
        }

        public String getLegacyCustomerNos() { return legacyCustomerNos; }
        public String getCustomerDescription() { return customerDescription; }
        public String getSalesOrganization() { return salesOrganization; }
        public String getAddress() { return address; }
        public String getEmailAddress() { return emailAddress; }
        public String getTelephoneNo1() { return telephoneNo1; }
        public String getPlant() { return plant; }
    }

    public static class CreditCustomer {

        private String credit_area;
        private String value;

        public CreditCustomer() {}

        public CreditCustomer(String credit_area, String value) {
            this.credit_area = credit_area;
            this.value = value;
        }

        public String getCredit_area() { return credit_area; }
        public String getValue() { return value; }
    }

    public static class CreditArea {

        public CreditArea() {}
    }
}
