package com.actionict.customer.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // override nei figli
    private Integer id;

    @UpdateTimestamp
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

//    @PrePersist
//    @PreUpdate
//    protected void updateTimestamp() {
//        this.lastUpdate = LocalDateTime.now();
//    }
//
//    public LocalDateTime getLastUpdate() {
//        return lastUpdate;
//    }
//
//    public void setLastUpdate(LocalDateTime lastUpdate) {
//        this.lastUpdate = lastUpdate;
//    }
}
