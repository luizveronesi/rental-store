package com.actionict.customer.controller;

import com.actionict.customer.entity.Customer;
import com.actionict.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() { return customerService.findAll(); }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable("id") Integer id) throws Exception { return customerService.findById(id); }

    @PostMapping("/insert")
    public ResponseEntity<Integer> insertCustomer(@RequestBody Customer customer) {
        Integer id = customerService.save(customer).getId();
        return new ResponseEntity<Integer>(id, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public void updateCustomer(@RequestBody Customer newCustomer, @PathVariable Integer id) { customerService.update(newCustomer, id); }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable Integer id) { customerService.delete(id); }
}