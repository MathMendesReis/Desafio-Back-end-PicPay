package com.develop.app.modules.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
@Table(name = "user_tb")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @JsonIgnore
  private UUID id;

  @NotBlank
  @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço")
  @Schema(example = "daniel", requiredMode = RequiredMode.REQUIRED, description = "Username do usuarios")
  private String userName;

  @NotBlank
  @Schema(example = "12345678901", requiredMode = RequiredMode.REQUIRED, description = "CPF do usuario")
  private String cpf;

  @Email
  @Schema(example = "example@gmail.com", requiredMode = RequiredMode.REQUIRED, description = "email do usuario")
  private String email;

  @Length(min = 10, max = 100, message = "A senha deve conter entre (10) e (100) caracteres")
  @Schema(example = "admin@1234", minLength = 10, maxLength = 100, requiredMode = RequiredMode.REQUIRED, description = "Senha do candidato")
  private String password;

  @Enumerated(EnumType.STRING)
  @Schema(example = "COMMON", requiredMode = RequiredMode.REQUIRED, description = "role do usuario que pode ser COMMON ou SHOPKEEPERS")
  private TypeUser typeUser;

  @CreatedDate
  @JsonIgnore
  private LocalDateTime createdAt;
}
  