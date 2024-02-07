package com.eadp.userserviceapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ShippingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_id")
    private Long propertyId;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String zip;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;
}