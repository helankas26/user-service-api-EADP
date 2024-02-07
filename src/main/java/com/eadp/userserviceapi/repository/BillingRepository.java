package com.eadp.userserviceapi.repository;

import com.eadp.userserviceapi.entity.BillingAddress;
import com.eadp.userserviceapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BillingRepository extends JpaRepository<BillingAddress, Long> {
    Optional<BillingAddress> findBillingAddressByUser(User user);
}
