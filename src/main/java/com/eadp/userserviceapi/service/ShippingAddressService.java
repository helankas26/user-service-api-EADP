package com.eadp.userserviceapi.service;

import com.eadp.userserviceapi.dto.common.ShippingAddressDto;

public interface ShippingAddressService {
    void saveAddress(String userId, ShippingAddressDto dto);

    ShippingAddressDto findAddress(String userId);

    void updateAddress(String userId, ShippingAddressDto dto);

    void deleteAddress(String userId);
}
