package com.testetecnicojava.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.testetecnicojava.api.dto.AddressDTO;
import com.testetecnicojava.api.dto.Payload;
import com.testetecnicojava.api.model.Address;
import com.testetecnicojava.api.services.AddressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/address")
public class AddressController {

  @Autowired
  private AddressService addressService;

  @PostMapping("/{personId}")
  @ResponseStatus(HttpStatus.CREATED)
  public void create (@RequestBody @Valid AddressDTO address, @PathVariable(value = "personId", required = true) Long personId){
    addressService.create(address, personId);
  }

  @GetMapping("/{personId}")
  @ResponseStatus(HttpStatus.OK)
  public List<Address> getAddressByPersonId(@PathVariable(value = "personId", required = true) Long personId){
    return addressService.findAllByPersonId(personId);
  }

  @GetMapping("/{personId}/{id}")
  @ResponseStatus(HttpStatus.OK)
  public List<Address> getAddressById(@PathVariable(value = "personId", required = true) Long personId, @PathVariable(value = "id", required = true) Long id){
    return addressService.findById(id, personId);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void updateAddressStatus(@PathVariable(value = "id", required = true) Long id, @RequestBody Payload payload){
    addressService.update(id, payload.getStatus());
  }
}
