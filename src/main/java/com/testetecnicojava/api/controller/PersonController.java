package com.testetecnicojava.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.testetecnicojava.api.dto.PersonDTO;
import com.testetecnicojava.api.model.Person;
import com.testetecnicojava.api.services.PersonServices;

@RestController
@RequestMapping("/api/person")
public class PersonController {

  @Autowired
  private PersonServices personServices;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody PersonDTO req){
    //criar services para fazer o tratamento dos dados recebidos
    personServices.create(req);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Person> findAll(){
    return personServices.findAll();
  }
}
