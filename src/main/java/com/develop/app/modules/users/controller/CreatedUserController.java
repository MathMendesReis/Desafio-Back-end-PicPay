package com.develop.app.modules.users.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.develop.app.modules.users.dto.CreatedUserRequestDTO;
import com.develop.app.modules.users.entity.Users;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class CreatedUserController {
  
  @PostMapping("/")
  public ResponseEntity<Object> execute(@Valid @RequestBody CreatedUserRequestDTO createdUserRequestDTO){
    try {
      Users user = Users.builder()
      .name(createdUserRequestDTO.name())
      .CPF(createdUserRequestDTO.CPF())
      .CNPJ(createdUserRequestDTO.CNPJ())
      .email(createdUserRequestDTO.email())
      .build();
      System.out.println(user);
      return ResponseEntity.ok().body(user);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
