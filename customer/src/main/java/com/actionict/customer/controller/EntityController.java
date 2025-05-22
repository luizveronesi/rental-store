package com.actionict.customer.controller;

import com.actionict.customer.model.BaseEntity;
import com.actionict.customer.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public abstract class EntityController<E extends BaseEntity> {

//    @Autowired
    protected final EntityService<E> entityService;

    protected EntityController(EntityService<E> entityService) {
        this.entityService = entityService;
    }

    // Trova tutti
    @GetMapping
    public ResponseEntity<List<E>> getAllEntities() {
        //new ResponseEntity<>(entityService.findAll(), HttpStatus.OK);
        return ResponseEntity.ok(entityService.findAll());
    }

    // Trova uno
    @GetMapping("/{id:\\d+}") // accetta solo numeri come {id}
    public ResponseEntity<E> getEntityById(@PathVariable int id) {
//        return new ResponseEntity<>(entityService.findById(id), HttpStatus.OK);
        return entityService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Inserisci
    @PostMapping()
    public ResponseEntity<Integer> addEntity(@RequestBody E country) {
        return new ResponseEntity<>(entityService.add(country), HttpStatus.CREATED);
    }

    // Aggiorna
    @PutMapping("/{id:\\d+}")
    public ResponseEntity<E> update(@PathVariable int id,
                                    @RequestBody E entity) {
        entity.setId(id);
        return ResponseEntity.ok(entityService.update(entity));
    }

    @PatchMapping("/{id:\\d+}")
    public ResponseEntity<E> partialUpdate(@PathVariable int id,
                                           @RequestBody Map<String, Object> updates) {
//        return new ResponseEntity<>(entityService.partialUpdate(id, updates), HttpStatus.OK);
        return ResponseEntity.ok(entityService.partialUpdate(id, updates));
    }

    // Elimina
    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<Void> deleteEntity(@PathVariable int id) {
        entityService.deleteById(id);
//        return new ResponseEntity<>(HttpStatus.OK);
        return ResponseEntity.noContent().build();
    }
}