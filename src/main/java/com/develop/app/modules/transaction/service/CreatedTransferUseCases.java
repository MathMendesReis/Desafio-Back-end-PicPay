package com.develop.app.modules.transaction.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develop.app.modules.transaction.DTO.CreatedTransferDTO;
import com.develop.app.modules.transaction.entity.TransactionEntity;
import com.develop.app.modules.transaction.repository.TransactionsRepository;
import com.develop.app.modules.user.TypeUser;
import com.develop.app.modules.user.UserEntity;
import com.develop.app.modules.user.repository.UserRepository;

@Service
public class CreatedTransferUseCases {
  @Autowired
  private TransactionsRepository transactionsRepository;

  @Autowired
  private UserRepository userRepository;

  public TransactionEntity execute(CreatedTransferDTO createdTransferDTO) throws Exception{
    UserEntity sender = userRepository.findById(createdTransferDTO.sendID())
      .orElseThrow(() -> new Exception("Sender not found"));

    UserEntity receiver = userRepository.findById(createdTransferDTO.receiverID())
      .orElseThrow(() -> new Exception("Receiver not found"));

      boolean isBalanceEnough = sender.getWalletBalance().compareTo(createdTransferDTO.value()) >= 0;
      if (!isBalanceEnough) {
      throw new Exception("Insufficient balance");
    }

    Boolean isTypeUser = sender.getTypeUser().equals(TypeUser.SHOPKEEPERS);

    if (isTypeUser) {
        throw new Exception("Unauthorized user");

    }
    Double newBalanceSend = sender.getWalletBalance().doubleValue() - createdTransferDTO.value().doubleValue();
    Double newBalanceReceveid = receiver.getWalletBalance().doubleValue() + createdTransferDTO.value().doubleValue();


    sender.setWalletBalance(BigDecimal.valueOf(newBalanceSend));
    receiver.setWalletBalance(BigDecimal.valueOf(newBalanceReceveid));


    this.userRepository.save(sender);
    this.userRepository.save(receiver);

    TransactionEntity transaction = TransactionEntity
    .builder()
    .amout(createdTransferDTO.value())
    .send(sender)
    .receiver(receiver)
    .timesTamp(LocalDateTime.now())
    .build();

    return this.transactionsRepository.save(transaction);
  }
}

 