package com.develop.app.modules.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.develop.app.modules.transaction.DTO.CreatedDepositDTO;
import com.develop.app.modules.transaction.DTO.CreatedTransferDTO;
import com.develop.app.modules.transaction.service.CreatedDepositUseCase;
import com.develop.app.modules.transaction.service.CreatedTransferUseCases;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private CreatedDepositUseCase createdDepositUseCase;

    
    @Autowired
    private CreatedTransferUseCases createdTransferUseCases;

    @PostMapping("/deposit")
    public ResponseEntity<Object> created(@Valid @RequestBody CreatedDepositDTO createdDepositDTO){
      try {
        var result = this.createdDepositUseCase.execute(createdDepositDTO);
        return ResponseEntity.ok().body(result);
      } catch (Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
      }
    }

    @PostMapping("/transfer")
    public ResponseEntity<Object> transfer(@Valid @RequestBody CreatedTransferDTO createdDepositDTO){
      try {
        var result = this.createdTransferUseCases.execute(createdDepositDTO);
        return ResponseEntity.ok().body(result);
      } catch (Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
      }
    }
}
