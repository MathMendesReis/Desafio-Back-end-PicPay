package com.develop.app.modules.user.dto;


import org.hibernate.validator.constraints.Length;

import com.develop.app.modules.user.TypeUser;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateUserRequestDTO(
  @NotBlank
  @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço")
  @Schema(example = "daniel", requiredMode = RequiredMode.REQUIRED, description = "Username do usuarios")
  String userName,

  @NotBlank
  @Schema(example = "12345678901", requiredMode = RequiredMode.REQUIRED, description = "CPF do usuario")
  String cpf,

  @Email
  @Schema(example = "example@gmail.com", requiredMode = RequiredMode.REQUIRED, description = "email do usuario")
  String email,

  @Length(min = 10, max = 100, message = "A senha deve conter entre (10) e (100) caracteres")
  @Schema(example = "admin@1234", minLength = 10, maxLength = 100, requiredMode = RequiredMode.REQUIRED, description = "Senha do candidato")
  String password,

  @Enumerated(EnumType.STRING)
  @Schema(example = "COMMON", requiredMode = RequiredMode.REQUIRED, description = "role do usuario que pode ser COMMON ou SHOPKEEPERS")
  TypeUser typeUser

) {
  
}


 