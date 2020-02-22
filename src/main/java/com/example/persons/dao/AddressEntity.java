package com.example.persons.dao;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class AddressEntity {

    @Id
    @GeneratedValue
    private Long id;


    private String city;
    private String street;

    @NotNull
    @OneToOne
    @JoinColumn(name = "persons_id", nullable = true)
    private PersonsEntity persons;
}
