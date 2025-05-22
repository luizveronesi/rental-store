package com.actionict.customer.service;

import com.actionict.customer.model.City;
import com.actionict.customer.model.Customer;
import com.actionict.customer.repository.CityRepository;
import com.actionict.customer.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends AbstractService<Customer> {
    public CustomerService(CustomerRepository entityRepository) {
        super(entityRepository);
    }

    public Page<Customer> searchByFirstName(String searchInput, Pageable pageable) {
        return ((CustomerRepository)super.entityRepository).searchByFirstName(searchInput,pageable);
    }
    public Page<Customer> searchByLastName(String searchInput, Pageable pageable) {
        return ((CustomerRepository)super.entityRepository).searchByLastName(searchInput,pageable);
    }
}
