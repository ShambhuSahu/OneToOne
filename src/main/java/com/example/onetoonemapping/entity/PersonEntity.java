package com.example.onetoonemapping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person")
public class PersonEntity {

    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long personId;
    private String firstname;
    private String lastName;


    @OneToOne
    @JoinColumn(name = "address_id")
    private AddressEntity addressEntity;


}
