package com.testetecnicojava.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.testetecnicojava.api.dto.PersonDTO;
import com.testetecnicojava.api.model.Person;
import com.testetecnicojava.api.repository.PersonRepository;

@Service
public class PersonServices {

  @Autowired
  private PersonRepository personRepository;

  public void create(PersonDTO person){
    List<Person> personExist = personRepository.findByNameAndBirthDate(person.name(), person.birthDate());
    if(personExist.isEmpty() == true) {
      personRepository.save(new Person(person));
    } else {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Esta pessoa já está cadastrada");
    }
  }

  public List<Person> findAll(){
    return personRepository.findAll();
  }

  public List<Person> findByNameContaining(String name){
    List<Person> result = personRepository.findByNameContainingIgnoreCase(name);
    if(result.isEmpty() == true) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não há pessoas cadastradas com este nome");
    } else return result;
  }
  
}
