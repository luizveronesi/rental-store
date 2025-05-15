package com.actionict.customer.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Short id;

    //@JoinColumn(name = "store.store_id")
    //@ManyToOne(fetch = FetchType.LAZY)
    private Short storeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @JoinColumn(name = "address_id")
    @ManyToOne(fetch = FetchType.LAZY)
    //@Column(name = "address_id")
    private Address address;

    @Column(name = "active")
    private boolean active;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}
