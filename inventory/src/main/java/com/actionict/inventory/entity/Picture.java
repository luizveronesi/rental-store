package com.actionict.inventory.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "picture")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "picture_id", nullable = false)
    private Integer pictureId;

    @JoinColumn(name = "film_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Film film;
}