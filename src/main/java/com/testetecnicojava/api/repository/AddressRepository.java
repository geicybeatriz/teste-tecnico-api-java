package com.testetecnicojava.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testetecnicojava.api.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

  List<Address> findByPersonId(Long personId);

  List<Address> findByCepAndPersonId(String cep, Long personId);
  
  List<Address> findByIdAndPersonId(Long id, Long personId);
  
}
