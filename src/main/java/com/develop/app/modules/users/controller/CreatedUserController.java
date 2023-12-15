package com.develop.app.modules.users.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.develop.app.modules.users.dto.CreatedUserRequestDTO;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("user")
public class CreatedUserController {
  
  @PostMapping("/")
  public ResponseEntity<Object> execute(@Valid @RequestBody CreatedUserRequestDTO createdUserRequestDTO){
    try {
      return ResponseEntity.ok().body("ok");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
