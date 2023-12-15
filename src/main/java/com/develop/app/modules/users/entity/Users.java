package com.develop.app.modules.users.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import com.develop.app.modules.users.enums.UserType;

@Entity
@Data
public class Users {
@Id
@GeneratedValue(strategy = GenerationType.UUID)
 private UUID id;

 @NotBlank(message = "")
 private String name;

 @NotBlank
 @CPF
 private String CPF;

 @Email
 private String  email;

 @NotBlank
 private String password;
 private String CNPJ;

 @Enumerated(EnumType.STRING)
 private UserType userType;
}
