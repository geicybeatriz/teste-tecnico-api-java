package com.testetecnicojava.api.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

public record PersonDTO(
  
  @NotBlank String name, 
  
  @Past Date birthDate
  ) {
}
