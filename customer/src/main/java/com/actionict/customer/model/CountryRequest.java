package com.actionict.customer.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CountryRequest {

    private String name;
    private LocalDateTime lastUpdate;
}
