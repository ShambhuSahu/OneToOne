package com.example.onetoonemapping.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

   private String address1;
   private String city;
   private String zip;
   private String state;

}
