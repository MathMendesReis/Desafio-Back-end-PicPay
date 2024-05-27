package com.develop.app.modules.transaction.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.develop.app.modules.transaction.entity.TransactionEntity;

public interface TransactionsRepository extends JpaRepository<TransactionEntity,UUID>{
  
}
