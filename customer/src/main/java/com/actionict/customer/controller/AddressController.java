package com.actionict.customer.controller;

import com.actionict.customer.model.Address;
import com.actionict.customer.model.City;
import com.actionict.customer.service.AddressService;
import com.actionict.customer.service.CityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers/addresses")
public class AddressController extends EntityController<Address> {

    public AddressController(AddressService service) {
        super(service);
    }
}