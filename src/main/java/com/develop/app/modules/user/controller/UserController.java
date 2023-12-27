package com.develop.app.modules.user.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.develop.app.modules.user.UserEntity;
import com.develop.app.modules.user.dto.CreateUserRequestDTO;
import com.develop.app.modules.user.service.CreateUserUseCase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")

public class UserController {

  @Autowired
  private CreateUserUseCase createUserUseCase;

  @PostMapping("/")
  @Operation(summary = "Cadastro de usuario.", description = "essa função e responsavel por cadastrar usuarios")
  @ApiResponses({
    @ApiResponse(responseCode = "200", content = {
      @Content(schema = @Schema(implementation = CreateUserRequestDTO.class))
    })
  })
  public ResponseEntity<Object> create (@Valid @RequestBody CreateUserRequestDTO createUserRequestDTO){
    try {
      UserEntity user = UserEntity.builder()
      .userName(createUserRequestDTO.userName())
      .cpf(createUserRequestDTO.cpf())
      .email(createUserRequestDTO.email())
      .password(createUserRequestDTO.password())
      .typeUser(createUserRequestDTO.typeUser())
      .createdAt(LocalDateTime.now())
      .build();
      this.createUserUseCase.execute(user);
      return ResponseEntity.ok().body("sucesso");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
