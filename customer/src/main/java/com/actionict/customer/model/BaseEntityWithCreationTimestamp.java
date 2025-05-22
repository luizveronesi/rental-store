package com.actionict.customer.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class BaseEntityWithCreationTimestamp extends BaseEntity {

    @CreationTimestamp
    @Immutable
    @Column(name = "create_date")
    private LocalDateTime createDate;

}
