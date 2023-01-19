package com.testetecnicojava.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testetecnicojava.api.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
  
  List<Person> findByNameAndBirthDate(String name, String birthDate);

}
