package com.actionict.customer.controller;

import com.actionict.customer.entity.City;
import com.actionict.customer.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public List<City> getAllCities() { return cityService.findAll(); }

    @GetMapping("/{id}")
    public City findCityById(@PathVariable("id") Integer id) throws Exception { return cityService.findById(id); }

    @PostMapping()
    public ResponseEntity<Integer> insertCity(@RequestBody City city) {
        Integer id = cityService.save(city).getId();
        return new ResponseEntity<Integer>(id, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public void updateCity(@RequestBody City newCity, @PathVariable Integer id) { cityService.update(newCity, id); }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Integer id) { cityService.delete(id); }
}
