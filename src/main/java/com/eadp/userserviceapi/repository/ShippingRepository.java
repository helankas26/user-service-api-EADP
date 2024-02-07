package com.eadp.userserviceapi.repository;

import com.eadp.userserviceapi.entity.ShippingAddress;
import com.eadp.userserviceapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShippingRepository extends JpaRepository<ShippingAddress, Long> {
    Optional<ShippingAddress> findShippingAddressByUser(User user);
}
