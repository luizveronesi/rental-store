package com.actionict.customer.service;

import com.actionict.customer.entity.Country;
import com.actionict.customer.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;
    /*@Autowired
    private CountryRepository countryRepository;*/

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Optional<Country> findById(Integer id) { return countryRepository.findById(id); }

    public Country save(Country country) { return countryRepository.save(country); }

    public Optional<Country> update(Country newCountry, Integer id) {
        return countryRepository.findById(id).map(country -> {
            country.setName(newCountry.getName());
            country.setLastUpdate(LocalDateTime.now());
            return countryRepository.save(country);
        });
    }

    public void delete(Integer id) { countryRepository.deleteById(id); }

    /*@Bean
    public CountryRepository countryRepository() { return new CountryRepository; }*/
}