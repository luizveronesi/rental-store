package com.actionict.customer.service;

import com.actionict.customer.model.Address;
import com.actionict.customer.model.City;
import com.actionict.customer.repository.AddressRepository;
import com.actionict.customer.repository.CityRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends AbstractService<Address> {
    public AddressService(AddressRepository entityRepository) {
        super(entityRepository);
    }
}
