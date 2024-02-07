package com.eadp.userserviceapi.service.impl;

import com.eadp.userserviceapi.dto.common.ShippingAddressDto;
import com.eadp.userserviceapi.entity.ShippingAddress;
import com.eadp.userserviceapi.entity.User;
import com.eadp.userserviceapi.repository.ShippingRepository;
import com.eadp.userserviceapi.repository.UserRepository;
import com.eadp.userserviceapi.service.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService {

    private final ShippingRepository shippingRepository;
    private final UserRepository userRepository;

    @Autowired
    public ShippingAddressServiceImpl(ShippingRepository shippingRepository, UserRepository userRepository) {
        this.shippingRepository = shippingRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void saveAddress(String userId, ShippingAddressDto dto) {
        Optional<User> selectedUser = userRepository.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();

        ShippingAddress shippingAddress = new ShippingAddress();

        shippingAddress.setCountry(dto.getCountry());
        shippingAddress.setCity(dto.getCity());
        shippingAddress.setZip(dto.getZip());
        shippingAddress.setUser(selectedUser.get());

        shippingRepository.save(shippingAddress);
    }

    @Override
    public ShippingAddressDto findAddress(String userId) {
        Optional<User> selectedUser = userRepository.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();

        Optional<ShippingAddress> selectedShippingAddress = shippingRepository.findShippingAddressByUser(selectedUser.get());
        if (selectedShippingAddress.isEmpty()) throw new RuntimeException();

        return new ShippingAddressDto(
                selectedShippingAddress.get().getCountry(),
                selectedShippingAddress.get().getCity(),
                selectedShippingAddress.get().getZip()
        );
    }

    @Override
    public void updateAddress(String userId, ShippingAddressDto dto) {
        Optional<User> selectedUser = userRepository.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();

        Optional<ShippingAddress> selectedShippingAddress = shippingRepository.findShippingAddressByUser(selectedUser.get());
        if (selectedShippingAddress.isEmpty()) throw new RuntimeException();

        selectedShippingAddress.get().setCountry(dto.getCountry());
        selectedShippingAddress.get().setCity(dto.getCity());
        selectedShippingAddress.get().setZip(dto.getZip());

        shippingRepository.save(selectedShippingAddress.get());
    }

    @Override
    public void deleteAddress(String userId) {
        Optional<User> selectedUser = userRepository.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();

        Optional<ShippingAddress> selectedShippingAddress = shippingRepository.findShippingAddressByUser(selectedUser.get());
        if (selectedShippingAddress.isEmpty()) throw new RuntimeException();

        shippingRepository.delete(selectedShippingAddress.get());
    }
}
