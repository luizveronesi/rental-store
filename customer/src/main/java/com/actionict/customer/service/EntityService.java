package com.actionict.customer.service;

import com.actionict.customer.model.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface EntityService<E extends BaseEntity> {

    // Trova tutti
    List<E> findAll();

    // Trova uno
    Optional<E> findById(int id);

    // Inserisci
    int add(E entity);

    // Sovrascrivi
    E update(E entity);

    // Aggiorna
    E partialUpdate(int id, Map<String, Object> updates);

    // Elimina
    void deleteById(int id);
}