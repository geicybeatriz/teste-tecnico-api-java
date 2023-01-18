package com.testetecnicojava.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testetecnicojava.api.dto.PersonDTO;
import com.testetecnicojava.api.repository.PersonRepository;

@RestController
@RequestMapping("/api/person")
public class PersonController {
  
  @Autowired
  private PersonRepository repository;

  @PostMapping
  public void create(@RequestBody PersonDTO req){
    
  }
}
