package com.develop.app.modules.user;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "user_tb")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  
  private String userName;

  private String cpf;

  private String email;

  private String password;

  @Enumerated(EnumType.STRING)
  private TypeUser typeUser;

  @CreatedDate
  @JsonIgnore
  private LocalDateTime createdAt;

  @Builder.Default
  private BigDecimal walletBalance = BigDecimal.ZERO;
}
  