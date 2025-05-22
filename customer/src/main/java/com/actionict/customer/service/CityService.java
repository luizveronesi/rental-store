package com.actionict.customer.service;

import com.actionict.customer.model.City;
import com.actionict.customer.model.Country;
import com.actionict.customer.repository.CityRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CityService extends AbstractService<City> {
    public CityService(CityRepository entityRepository) {
        super(entityRepository);
    }
}
