package com.develop.app.modules.user.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.develop.app.modules.user.TypeUser;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record CreateUserRequestDTO(
  @NotBlank
  @NotEmpty
  String userName,

  @NotBlank
  @CPF
  String CPF,

  @Email
  String email,

  @NotBlank
  @Length(min = 8)
  String password,

  @Enumerated(EnumType.STRING)
  TypeUser typeUser
) {
  
}


 