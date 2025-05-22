package com.actionict.customer.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "customer")
@AttributeOverride(name = "id", column = @Column(name = "customer_id"))
public class Customer extends BaseEntityWithCreationTimestamp {

    public static final String LAST_NAME = "lastName";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME_LOWER = LAST_NAME.toLowerCase();
    public static final String FIRST_NAME_LOWER = FIRST_NAME.toLowerCase();

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "customer_id")
//    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "active")
    private boolean active;

//    @CreationTimestamp
//    @Column(name = "create_date")
//    private LocalDateTime createDate;

//    @UpdateTimestamp
//    @Column(name = "last_update")
//    private LocalDateTime lastUpdate;

    // Join con la tabella Address
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    // TODO DA IMPLEMENTARE IN FUTURO?
    // Join con la tabella Store
//    @ManyToOne
//    @JoinColumn(name = "store_id")
//    private Store store;
}
