package com.actionict.customer.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "country_id")
    @ManyToOne(fetch = FetchType.LAZY)
    //@Column(name = "country_id")
    private Country country;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}
