package com.actionict.customer.service;

import com.actionict.customer.model.BaseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractService<E extends BaseEntity> implements EntityService<E> {

//    @Autowired
//    private final CountryRepository entityRepository;
    protected final JpaRepository<E, Integer> entityRepository;

    public AbstractService(JpaRepository<E, Integer> entityRepository) {
        this.entityRepository = entityRepository;
    }

    @Autowired
    private ObjectMapper objectMapper;

    // Trova tutti
    public List<E> findAll() {
        return entityRepository.findAll();
    }

    // Trova uno
    public Optional<E> findById(int id) {
        return entityRepository.findById(id);
    }

    @Transactional
    @Override
    public int add(E entity) {
        if (entity.getId() != null) {
            // L'id è valorizzato → allora controllo se esiste nel DB
            Optional<E> existing = entityRepository.findById(entity.getId());
            if (existing.isPresent()) {
                throw new IllegalArgumentException("Country con ID già esistente: aggiornamento non permesso da qui.");
            }
        }

        // In questo punto, entity.getId() è null o non esiste nel DB → safe insert
        return entityRepository.save(entity).getId();
    }


    // Aggiorna
    @Transactional
    @Override
    public E update(E entity) {
        if (entity == null || entity.getId() == null) {
            throw new IllegalArgumentException("Impossibile aggiornare: ID mancante.");
        }

        E existing = entityRepository.findById(entity.getId())
                .orElseThrow(() -> new EntityNotFoundException("ID non trovato: " + entity.getId()));

        // Imposto i campi da aggiornare
//        existing.setName(entity.getName());

        // Sovrascrivo tutto
        return entityRepository.save(entity);
    }


    // Aggiorna
    @Transactional
    @Override
    public E partialUpdate(int id, Map<String, Object> updates) {
        E existing = entityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Id non trovato: " + id));

        // throw exception if request body contains "id" key
        if (updates.containsKey("id")) {
            throw new RuntimeException("Id non consentito in request body");
        }

        // Imposto i campi da aggiornare
        E patchedCountry = patch(existing, updates);

        return entityRepository.save(patchedCountry);
    }

    private E patch(E existing, Map<String, Object> updates) {

        // Convert Country object to a JSON object node
        ObjectNode existingNode = objectMapper.convertValue(existing, ObjectNode.class);

        // Convert the updates map to a JSON object node
        ObjectNode updatesNode = objectMapper.convertValue(updates, ObjectNode.class);

        // Merge the patch updates into the existing node
        existingNode.setAll(updatesNode);

        return (E) objectMapper.convertValue(existingNode, existing.getClass());
    }


    // Elimina
    @Transactional
    @Override
    public void deleteById(int id) {
        Optional<E> existing = entityRepository.findById(id);
        if(existing.isPresent()) {
            entityRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Id non trovato: " + id);
        }

//        existing.ifPresentOrElse(entityRepository::delete, () -> new EntityNotFoundException("Id non trovato: " + id));
    }

}