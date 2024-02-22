package com.eadp.userserviceapi.service;

import com.eadp.userserviceapi.dto.common.BillingAddressDto;

public interface BillingAddressService {
    void saveAddress(int userId, BillingAddressDto dto);

    BillingAddressDto findAddress(int userId);

    void updateAddress(int userId, BillingAddressDto dto);

    void deleteAddress(int userId);
}
