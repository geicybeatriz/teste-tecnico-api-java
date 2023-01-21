package com.testetecnicojava.api.dto;

import jakarta.validation.constraints.NotBlank;

public record AddressDTO (

  @NotBlank String street,

  @NotBlank String number,

  @NotBlank String cep,

  @NotBlank String city,

  Boolean isMainAddress

){}
