package com.actionict.customer.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AttributeOverride(name = "id", column = @Column(name = "city_id"))
@Table(name = "city")
public class City extends BaseEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "city_id")
//    private Integer id;

    @Column(name = "name")
    private String name;

//    @UpdateTimestamp
//    @Column(name = "last_update")
//    private LocalDateTime lastUpdate;

    // Join con la tabella Country
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    // Lista di indirizzi per la join sulla tabella Address
//    @OneToMany(mappedBy = "city",
//            fetch = FetchType.LAZY,
//            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
//    private List<Address> addresses;
}
