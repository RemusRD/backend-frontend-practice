package com.example.backendfrontendpractice.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class User {
    @Id
    private String id;
    @Column(unique = true)
    private String username;
    private String password;
    private int age;

    @OneToMany(mappedBy = "owner")
    private List<Invoice> invoices;


}
