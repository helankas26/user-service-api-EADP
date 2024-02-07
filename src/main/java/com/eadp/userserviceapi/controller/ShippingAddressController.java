package com.eadp.userserviceapi.controller;

import com.eadp.userserviceapi.dto.common.ShippingAddressDto;
import com.eadp.userserviceapi.service.ShippingAddressService;
import com.eadp.userserviceapi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class ShippingAddressController {
    private final ShippingAddressService shippingAddressService;

    @Autowired
    public ShippingAddressController(ShippingAddressService shippingAddressService) {
        this.shippingAddressService = shippingAddressService;
    }

    @PostMapping(params = "userId")
    public ResponseEntity<StandardResponse> createUser(@RequestParam String userId, @RequestBody ShippingAddressDto dto) {
        shippingAddressService.saveAddress(userId, dto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Address was Saved!", null),
                HttpStatus.CREATED
        );
    }

    @PutMapping(params = "userid")
    public ResponseEntity<StandardResponse> updateUser(@RequestParam String userId, @RequestBody ShippingAddressDto dto) {
        shippingAddressService.updateAddress(userId, dto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Address was updated!", null),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{userId}")
    public ResponseEntity<StandardResponse> findUser(@PathVariable String userId) {
        return new ResponseEntity<>(
                new StandardResponse(200, "Address data", shippingAddressService.findAddress(userId)),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<StandardResponse> deleteUser(@PathVariable String userId) {
        shippingAddressService.deleteAddress(userId);
        return new ResponseEntity<>(
                new StandardResponse(204, "Address was Deleted!", null),
                HttpStatus.NO_CONTENT
        );
    }
}
