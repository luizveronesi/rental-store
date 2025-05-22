package com.actionict.customer.repository;

import com.actionict.customer.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from Customer where first_name = ?1 or last_name = ?1", nativeQuery = true)
    Page<Customer> findByName(String name, Pageable pageable);
}