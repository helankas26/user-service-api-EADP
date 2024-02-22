package com.eadp.userserviceapi.service;

import com.eadp.userserviceapi.dto.common.ShippingAddressDto;

public interface ShippingAddressService {
    void saveAddress(int userId, ShippingAddressDto dto);

    ShippingAddressDto findAddress(int userId);

    void updateAddress(int userId, ShippingAddressDto dto);

    void deleteAddress(int userId);
}
