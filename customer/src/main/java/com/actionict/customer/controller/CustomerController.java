package com.actionict.customer.controller;

import com.actionict.customer.model.Customer;
import com.actionict.customer.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.actionict.customer.model.Customer.FIRST_NAME;
import static com.actionict.customer.model.Customer.LAST_NAME;

@RestController
@RequestMapping("/customers/customers")
public class CustomerController extends EntityController<Customer> {

    public CustomerController(CustomerService service) {
        super(service);
    }


    @GetMapping("/search")
    public ResponseEntity<Page<Customer>> searchCustomers(
            @RequestParam String searchInput,
            @RequestParam(defaultValue = "0") int page) {

        if (searchInput == null || searchInput.length() < 2) {
            return ResponseEntity
                    .badRequest()
                    .body(Page.empty()); // oppure puoi restituire un messaggio personalizzato
        }

        return ResponseEntity.ok(
                    ((CustomerService)entityService).searchByName(searchInput, page)
                );
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