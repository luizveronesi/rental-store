package com.actionict.customer.controller;

import com.actionict.customer.model.Country;
import com.actionict.customer.service.AbstractService;
import com.actionict.customer.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers/countries")
public class CountryController extends EntityController<Country> {

    public CountryController(CountryService service) {
        super(service);
    }

    // IN CASO DOVESSI FARE OVERRIDE??
    // Trova uno
    @Override
    @GetMapping("/{id:\\d+}")
    public ResponseEntity<Country> getEntityById(@PathVariable int id) {
        System.out.println("============= Override done successfully! =============");
        return super.getEntityById(id);
    }
}