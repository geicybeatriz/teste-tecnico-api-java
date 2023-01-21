package com.testetecnicojava.api.model;

import com.testetecnicojava.api.dto.AddressDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 200, nullable = false)
  private String street;

  @Column(length = 50, nullable = false)
  private String number;

  @Column(length = 50, nullable = false)
  private String cep;

  @Column(length = 100, nullable = false)
  private String city;

  @Column(length = 200 , nullable = false)
  private Long personId;

  @Column(length = 10, nullable = false)
  private Boolean isMainAddress;  

  public Address(AddressDTO address, Long personId){
    this.street = address.street();
    this.number = address.number();
    this.cep = address.cep();
    this.city = address.city();
    this.isMainAddress = address.isMainAddress();
    this.personId = personId;
  }
}
