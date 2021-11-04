package com.example.backendfrontendpractice.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Invoice {
    @Id
    private String id;
    private int number;
    private BigDecimal total;
    @ManyToOne
    private User owner;
    @ManyToMany
    private List<Product> products;
}
