package com.testetecnicojava.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.testetecnicojava.api.dto.AddressDTO;
import com.testetecnicojava.api.model.Address;
import com.testetecnicojava.api.repository.AddressRepository;

@Service
public class AddressService {

  @Autowired
  private AddressRepository addressRepository;

  @Autowired
  private PersonServices personServices;

  public void create(AddressDTO address, Long personId){
    personServices.findById(personId);
    
    List<Address> checkAddress = addressRepository.findByCepAndPersonId(address.cep(), personId);
    if(checkAddress.isEmpty() == true){
      addressRepository.save(new Address(address, personId));
    } else {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Este endereço já está cadastrado e vinculado a esta pessoa");
    }
  }

  public List<Address> findAllByPersonId(Long personId){
    return addressRepository.findByPersonId(personId);
  }

  public List<Address> findById(Long id, Long personId){
    personServices.findById(personId);
    return addressRepository.findByIdAndPersonId(id, personId);
  }

  public void update(Long id, Boolean ismainAddress){
    addressRepository
      .findById(id)
      .map( address -> {
        address.setIsMainAddress(ismainAddress);
        addressRepository.save(address);
        return Void.TYPE;
      })
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado"));
  }

}
