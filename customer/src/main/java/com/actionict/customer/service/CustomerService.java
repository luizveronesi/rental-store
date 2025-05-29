package com.actionict.customer.service;

import com.actionict.customer.model.Customer;
import com.actionict.customer.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import static com.actionict.customer.model.Customer.FIRST_NAME;
import static com.actionict.customer.model.Customer.LAST_NAME;

@Service
public class CustomerService extends AbstractService<Customer> {
    public CustomerService(CustomerRepository entityRepository) {
        super(entityRepository);
    }

    public Page<Customer> searchByName(String searchInput, int page) {
        Pageable pageable = PageRequest.of(page, 2, Sort.by(LAST_NAME, FIRST_NAME).ascending());
        return ((CustomerRepository)super.entityRepository).searchByName(searchInput,pageable);
    }
}
