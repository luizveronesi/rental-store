package com.actionict.customer.repository;

import com.actionict.customer.model.City;
import com.actionict.customer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("""
        SELECT c FROM Customer c\s
        WHERE LENGTH(:searchInput) >= 2 AND\s
              (
              LOWER(c.firstName) LIKE LOWER(CONCAT(:searchInput, '%'))
              \sOR\s
              LOWER(c.lastName) LIKE LOWER(CONCAT(:searchInput, '%'))
              )
        """)
//    ORDER BY c.lastName, c.firstName ??
    Page<Customer> searchByName(@Param("searchInput") String searchInput, Pageable pageable);
}