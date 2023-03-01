package com.example.onetoonemapping.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "address")
public class AddressEntity {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;
    private String address1;
    private String city;
    private String zip;
    private String state;

    @OneToOne
    @JoinColumn(name = "address_id")
    private PersonEntity personEntity;

}
