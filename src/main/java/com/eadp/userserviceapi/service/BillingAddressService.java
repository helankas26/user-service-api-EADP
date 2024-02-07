package com.eadp.userserviceapi.service;

import com.eadp.userserviceapi.dto.common.BillingAddressDto;

public interface BillingAddressService {
    void saveAddress(String userId, BillingAddressDto dto);

    BillingAddressDto findAddress(String userId);

    void updateAddress(String userId, BillingAddressDto dto);

    void deleteAddress(String userId);
}
