package com.joshuauwagwu.reactivedatamanipulation.repository;

import com.joshuauwagwu.reactivedatamanipulation.dto.CustomerDbResponse;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class CustomerRepository {

    private final DatabaseClient databaseClient;
    public CustomerRepository(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    public Mono<CustomerDbResponse> findCustomerByCode(String customerCode) {
        String sql = """
                SELECT TOP 1 [Customer Code] as CustomerCode
                ,'' as LegacyCode
                ,[Region Code] as RegionCode
                      ,[Business Name] as BusinessName
                      ,[Address] as Address
                  FROM [DataMart].[sales].[Customers]
                  WHERE [Customer Code] = :customerCode
                """;
        return databaseClient.sql(sql)
                .bind("customerCode", customerCode)
                .map((row, metadata) -> new CustomerDbResponse(
                        row.get("CustomerCode", String.class),
                        row.get("LegacyCode", String.class),
                        row.get("BusinessName", String.class),
                        row.get("RegionCode", String.class),
                        row.get("Address", String.class)
                ))
                .one();
    }
}
