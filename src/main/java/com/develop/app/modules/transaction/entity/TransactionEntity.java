package com.develop.app.modules.transaction.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.develop.app.modules.user.UserEntity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "transactions_tb")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private BigDecimal amout;
  @ManyToOne
  @JoinColumn(name="receiver_id")
  private UserEntity receiver;
  @ManyToOne
  @JoinColumn(name="send_id")
  private UserEntity send;
  private LocalDateTime timesTamp;
}
