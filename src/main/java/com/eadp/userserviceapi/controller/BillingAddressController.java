package com.eadp.userserviceapi.controller;

import com.eadp.userserviceapi.dto.common.BillingAddressDto;
import com.eadp.userserviceapi.service.BillingAddressService;
import com.eadp.userserviceapi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/billing")
public class BillingAddressController {
    private final BillingAddressService billingAddressService;

    @Autowired
    public BillingAddressController(BillingAddressService billingAddressService) {
        this.billingAddressService = billingAddressService;
    }

    @PostMapping(params = "userId")
    public ResponseEntity<StandardResponse> createUser(@RequestParam String userId, @RequestBody BillingAddressDto dto) {
        billingAddressService.saveAddress(Integer.parseInt(userId), dto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Address was Saved!", null),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{userId}")
    public ResponseEntity<StandardResponse> findUser(@PathVariable String userId) {
        return new ResponseEntity<>(
                new StandardResponse(200, "Address data", billingAddressService.findAddress(Integer.parseInt(userId))),
                HttpStatus.OK
        );
    }

    @PutMapping(params = "userid")
    public ResponseEntity<StandardResponse> updateUser(@RequestParam String userId, @RequestBody BillingAddressDto dto) {
        billingAddressService.updateAddress(Integer.parseInt(userId), dto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Address was updated!", null),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<StandardResponse> deleteUser(@PathVariable String userId) {
        billingAddressService.deleteAddress(Integer.parseInt(userId));
        return new ResponseEntity<>(
                new StandardResponse(204, "Address was Deleted!", null),
                HttpStatus.NO_CONTENT
        );
    }
}
