package com.example.onetoonemapping.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequest {

    private String firstname;
    private String lastName;

    private AddressRequest addresst;


}
