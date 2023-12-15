package com.develop.app.modules.transactions.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.develop.app.modules.users.entity.Users;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class Transactions {
  @Id 
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private BigDecimal amount;

  @ManyToOne
  @JoinColumn(name = "sender_id")
  private Users sender;
  @ManyToOne
  @JoinColumn(name = "reveiver_id")
  private Users reveiver;

  private LocalDateTime timestamp;
}
