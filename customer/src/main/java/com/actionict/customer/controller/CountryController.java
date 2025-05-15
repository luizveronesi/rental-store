package com.actionict.customer.controller;

import com.actionict.customer.entity.Country;
import com.actionict.customer.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Country> getCountryById(@PathVariable("id") Short id) { return countryService.findById(id); }

    @PostMapping("/insert")
    public ResponseEntity<Short> insertCountry(@RequestBody Country country) {
        Short id = countryService.save(country).getId();
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public Optional<Country> updateCountry(@RequestBody Country newCountry, @PathVariable Short id) {
        return countryService.update(newCountry, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCountry(@PathVariable Short id) { countryService.delete(id); }
}