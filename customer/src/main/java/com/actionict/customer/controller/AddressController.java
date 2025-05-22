package com.actionict.customer.controller;

import com.actionict.customer.entity.Address;
import com.actionict.customer.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public List<Address> getAllAddresses() { return addressService.findAll(); }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable("id") Integer id) throws Exception { return addressService.findById(id); }

    @PostMapping()
    public ResponseEntity<Integer> insertAddress(@RequestBody Address address) {
        Integer id = addressService.save(address).getId();
        return new ResponseEntity<Integer>(id, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public void updateAddress(@RequestBody Address newAddress, @PathVariable Integer id) { addressService.update(newAddress, id); }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Integer id) { addressService.delete(id); }
}