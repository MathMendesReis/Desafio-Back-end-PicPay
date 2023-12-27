package com.develop.app.modules.transaction.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develop.app.modules.transaction.DTO.CreatedDepositDTO;
import com.develop.app.modules.transaction.entity.TransactionEntity;
import com.develop.app.modules.transaction.repository.TransactionsRepository;
import com.develop.app.modules.user.UserEntity;
import com.develop.app.modules.user.repository.UserRepository;

@Service
public class CreatedDepositUseCase {

  @Autowired
  private TransactionsRepository transactionsRepository;

  @Autowired
  private UserRepository userRepository;


  public TransactionEntity execute(CreatedDepositDTO createdDepositDTO) throws Exception{
    UserEntity userReceivedId = this.userRepository.findAllById(createdDepositDTO.receivedId())
    .orElseThrow(() -> new Exception("Usuário não encontrado"));

    Double amount = userReceivedId.getWalletBalance().doubleValue() + createdDepositDTO.value().doubleValue();
    BigDecimal amountAsBigDecimal = BigDecimal.valueOf(amount);

    userReceivedId.setWalletBalance(amountAsBigDecimal);

    TransactionEntity transaction = TransactionEntity.builder()
    .amout(createdDepositDTO.value())
    .receiver(userReceivedId)
    .timesTamp(LocalDateTime.now())
    .build();
    this.userRepository.save(userReceivedId);

    return this.transactionsRepository.save(transaction);
  }
}
