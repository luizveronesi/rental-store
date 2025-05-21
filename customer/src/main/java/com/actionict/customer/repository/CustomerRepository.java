package com.actionict.customer.repository;

import com.actionict.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);
}