package com.develop.app.modules.users.dto;

import com.develop.app.modules.users.enums.UserType;

public record CreatedUserRequestDTO(
  String name, 
  String CPF, 
  String email, 
  String password,
  UserType userType,
  String CNPJ
  ) {
  
}
