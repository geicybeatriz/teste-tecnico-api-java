package com.testetecnicojava.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.testetecnicojava.api.dto.PersonDTO;
import com.testetecnicojava.api.model.Person;
import com.testetecnicojava.api.services.PersonServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/person")
public class PersonController {

  @Autowired
  private PersonServices personServices;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@RequestBody @Valid PersonDTO req){
    personServices.create(req);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Person> findAll(@RequestParam(required = false) String name){
    if (name != null){
      return personServices.findByNameContaining(name);
    } else return personServices.findAll();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Person findPersonById(@PathVariable("id") Long id){
    return personServices
      .findById(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada"));
  }
}
