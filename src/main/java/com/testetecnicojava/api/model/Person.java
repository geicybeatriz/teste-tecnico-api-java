package com.testetecnicojava.api.model;

import java.util.Date;

import com.testetecnicojava.api.dto.PersonDTO;

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
public class Person{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 100, nullable = false)
  private String name;

  @Column(nullable = false)
  private Date birthDate;  


  public Person(PersonDTO data){
    this.name = data.name();
    this.birthDate = data.birthDate();
  }
}