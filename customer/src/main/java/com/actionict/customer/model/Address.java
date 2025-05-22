package com.actionict.customer.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AttributeOverride(name = "id", column = @Column(name = "address_id"))
@Table(name = "address")
public class Address extends BaseEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "address_id")
//    private Integer id;

    @Column(name = "address")
    private String address;

    @Column(name = "address2")
    private String address2;

    @Column(name = "district")
    private String district;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "phone")
    private String phoneNumber;

//    @UpdateTimestamp
//    @Column(name = "last_update")
//    private LocalDateTime lastUpdate;

    // Join con la tabella City
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    // Lista di clienti per la join sulla tabella Customer
//    @OneToMany(mappedBy = "address",
//            fetch = FetchType.LAZY,
//            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
//    private List<Customer> customers;
}
