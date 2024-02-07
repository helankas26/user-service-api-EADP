package com.eadp.userserviceapi.service.impl;

import com.eadp.userserviceapi.dto.common.BillingAddressDto;
import com.eadp.userserviceapi.entity.BillingAddress;
import com.eadp.userserviceapi.entity.User;
import com.eadp.userserviceapi.repository.BillingRepository;
import com.eadp.userserviceapi.repository.UserRepository;
import com.eadp.userserviceapi.service.BillingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillingAddressServiceImpl implements BillingAddressService {

    private final BillingRepository billingRepository;
    private final UserRepository userRepository;

    @Autowired
    public BillingAddressServiceImpl(BillingRepository billingRepository, UserRepository userRepository) {
        this.billingRepository = billingRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void saveAddress(String userId, BillingAddressDto dto) {
        Optional<User> selectedUser = userRepository.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();

        BillingAddress billingAddress = new BillingAddress();

        billingAddress.setCountry(dto.getCountry());
        billingAddress.setCity(dto.getCity());
        billingAddress.setZip(dto.getZip());
        billingAddress.setUser(selectedUser.get());

        billingRepository.save(billingAddress);
    }

    @Override
    public BillingAddressDto findAddress(String userId) {
        Optional<User> selectedUser = userRepository.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();

        Optional<BillingAddress> selectedBillingAddress = billingRepository.findBillingAddressByUser(selectedUser.get());
        if (selectedBillingAddress.isEmpty()) throw new RuntimeException();

        return new BillingAddressDto(
                selectedBillingAddress.get().getCountry(),
                selectedBillingAddress.get().getCity(),
                selectedBillingAddress.get().getZip()
        );
    }

    @Override
    public void updateAddress(String userId, BillingAddressDto dto) {
        Optional<User> selectedUser = userRepository.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();

        Optional<BillingAddress> selectedBillingAddress = billingRepository.findBillingAddressByUser(selectedUser.get());
        if (selectedBillingAddress.isEmpty()) throw new RuntimeException();

        selectedBillingAddress.get().setCountry(dto.getCountry());
        selectedBillingAddress.get().setCity(dto.getCity());
        selectedBillingAddress.get().setZip(dto.getZip());

        billingRepository.save(selectedBillingAddress.get());
    }

    @Override
    public void deleteAddress(String userId) {
        Optional<User> selectedUser = userRepository.findUserByUserId(userId);
        if (selectedUser.isEmpty()) throw new RuntimeException();

        Optional<BillingAddress> selectedBillingAddress = billingRepository.findBillingAddressByUser(selectedUser.get());
        if (selectedBillingAddress.isEmpty()) throw new RuntimeException();

        billingRepository.delete(selectedBillingAddress.get());
    }
}
