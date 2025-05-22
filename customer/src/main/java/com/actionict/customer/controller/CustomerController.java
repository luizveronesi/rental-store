package com.actionict.customer.controller;

import com.actionict.customer.model.Customer;
import com.actionict.customer.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController extends EntityController<Customer> {

    public CustomerController(CustomerService service) {
        super(service);
    }


    private static final String LAST_NAME = "lastName";
    private static final String FIRST_NAME = "firstName";
    @GetMapping("/search")
    public ResponseEntity<Page<Customer>> searchCustomers(
            @RequestParam(defaultValue = LAST_NAME) String searchParam,
            @RequestParam String searchInput,
            @RequestParam(defaultValue = "0") int page) {

        if (searchParam == null || searchInput == null || searchInput.length() < 2) {
            return ResponseEntity
                    .badRequest()
                    .body(Page.empty()); // oppure puoi restituire un messaggio personalizzato
        }

        Pageable pageable = PageRequest.of(page, 2, Sort.by(LAST_NAME, FIRST_NAME).ascending());
//        Page<Customer> results = ((CustomerService)entityService).searchByName(searchParam, searchInput, pageable);
//        return ResponseEntity.ok(results);

        return switch (searchParam) {
            case LAST_NAME  -> ResponseEntity.ok(
                    ((CustomerService)entityService).searchByLastName(searchInput, pageable)
            );
            case FIRST_NAME -> ResponseEntity.ok(
                    ((CustomerService)entityService).searchByFirstName(searchInput, pageable)
            );
            default -> ResponseEntity
                    .badRequest()
                    .body(Page.empty());
        };
    }


    private boolean isThereAnInputError(String searchParam, String searchInput) {
        // E' un errore se almeno una condizione è vera:
        return
                // l'input è più corto di 2 caratteri
                searchInput.length() < 2
                        // l'ordinamento è nullo
                        || searchParam == null
                        // l'ordinamento è diverso da "firstName" o "lastName"
                        ||
                            !(searchParam.equals(FIRST_NAME) || searchParam.equals(LAST_NAME))
                ;
    }
}