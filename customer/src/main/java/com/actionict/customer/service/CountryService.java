package com.actionict.customer.service;

import com.actionict.customer.entity.Country;
import com.actionict.customer.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Optional<Country> findById(Short id) { return countryRepository.findById(Integer.valueOf(id)); }

    public Country save(Country country) { return countryRepository.save(country); }

    public Optional<Country> update(Country newCountry, Short id) {
        return countryRepository.findById(Integer.valueOf(id)).map(country -> {
            country.setName(newCountry.getName());
            country.setLastUpdate(LocalDateTime.now());
            return countryRepository.save(country);
        });
    }

    public void delete(Short id) { countryRepository.deleteById(Integer.valueOf(id)); }

    /*@Bean
    public CountryRepository countryRepository() { return new CountryRepository; }*/
}