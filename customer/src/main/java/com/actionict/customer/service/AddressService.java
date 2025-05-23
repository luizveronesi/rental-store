package com.actionict.customer.service;

import com.actionict.customer.entity.Address;
import com.actionict.customer.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public List<Address> findAll() { return addressRepository.findAll(); }

    public Address findById(Integer id) throws Exception {return addressRepository.findById(id).orElseThrow(() -> new Exception("Address with id "+id+" not found")); }

    public Address save(Address address) { return addressRepository.save(address); }

    public void update(Address newAddress, Integer id) {
        addressRepository.findById(id).map( address -> {
            address.setAddress(newAddress.getAddress());
            address.setAddress2(newAddress.getAddress2());
            address.setDistrict(newAddress.getDistrict());
            address.setCity(newAddress.getCity());
            address.setPostalCode(newAddress.getPostalCode());
            address.setPhone(newAddress.getPhone());
            address.setLastUpdate(LocalDateTime.now());
            return addressRepository.save(address);
        });
    }

    public void delete(Integer id) {addressRepository.deleteById(id); }
}