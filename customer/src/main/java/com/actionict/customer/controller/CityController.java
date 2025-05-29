package com.actionict.customer.controller;

import com.actionict.customer.model.City;
import com.actionict.customer.service.AbstractService;
import com.actionict.customer.service.CityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers/cities")
public class CityController extends EntityController<City> {

    public CityController(CityService service) {
        super(service);
    }
}