package com.actionict.customer.controller;

import com.actionict.customer.entity.Customer;
import com.actionict.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/name")
    public Page<Customer> search(@RequestParam(name = "name", required = false) String name, Pageable pageable) { return customerService.findAll(name, pageable); }

    @GetMapping
    public Page<Customer> getAllCustomers() { return customerService.findAll("", Pageable.unpaged()); }

    @GetMapping("/page")
    public Page getAllCustomersPage(@PageableDefault(sort = "id") Pageable pageable) { return customerService.findAllPage(pageable); }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable("id") Integer id) throws Exception { return customerService.findById(id); }

    @PostMapping()
    public ResponseEntity<Integer> insertCustomer(@RequestBody Customer customer) {
        Integer id = customerService.save(customer).getId();
        return new ResponseEntity<Integer>(id, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@RequestBody Customer newCustomer, @PathVariable Integer id) { customerService.update(newCustomer, id); }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Integer id) { customerService.delete(id); }
}