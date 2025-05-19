package com.actionict.customer.service;

import com.actionict.customer.entity.City;
import com.actionict.customer.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public List<City> findAll() { return cityRepository.findAll(); }

    public City findById(Integer id) throws Exception { return cityRepository.findById(id).orElseThrow(() -> new Exception("City with id "+id+" not found")); }

    public City save(City city) { return cityRepository.save(city); }

    public void update(City newCity, Integer id) {
        cityRepository.findById(id).map(city -> {
            city.setName(newCity.getName());
            city.setCountry(newCity.getCountry());
            city.setLastUpdate(LocalDateTime.now());
            return cityRepository.save(city);
        });
    }

    public void delete(Integer id) { cityRepository.deleteById(id); }
}