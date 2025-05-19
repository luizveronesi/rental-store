package com.actionict.customer.service;

import com.actionict.customer.entity.Country;
import com.actionict.customer.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public List<Country> findAll() { return countryRepository.findAll(); }

    public Page<Country> findAllPage(final Pageable pageable) {
        Page<Country> page = countryRepository.findAll(pageable);
        return page;
    }

    public Country findById(Integer id) throws Exception { return countryRepository.findById(id).orElseThrow(() -> new Exception("Country with id "+id+" not found")); }

    public Country save(Country country) { return countryRepository.save(country); }

    public void update(Country newCountry, Integer id) {
        countryRepository.findById(id).map(country -> {
            country.setName(newCountry.getName());
            country.setLastUpdate(LocalDateTime.now());
            return countryRepository.save(country);
        });
    }

    public void delete(Integer id) { countryRepository.deleteById(id); }

}