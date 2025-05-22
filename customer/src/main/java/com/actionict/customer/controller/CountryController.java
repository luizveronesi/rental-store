package com.actionict.customer.controller;

import com.actionict.customer.entity.Country;
import com.actionict.customer.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.findAll();
    }

    @GetMapping("/page")
    public Page getAllCountriesPaged(@PageableDefault(size = 2) Pageable pageable) { return countryService.findAllPage(pageable); }

    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable("id") Integer id) throws Exception { return countryService.findById(id); }

    @PostMapping()
    public ResponseEntity<Integer> insertCountry(@RequestBody Country country) {
        Integer id = countryService.save(country).getId();
        return new ResponseEntity<Integer>(id, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public void updateCountry(@RequestBody Country newCountry, @PathVariable Integer id) {
        countryService.update(newCountry, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable Integer id) { countryService.delete(id); }
}