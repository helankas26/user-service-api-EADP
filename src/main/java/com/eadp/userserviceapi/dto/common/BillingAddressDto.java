package com.eadp.userserviceapi.dto.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BillingAddressDto {
    private String country;
    private String city;
    private String zip;
}