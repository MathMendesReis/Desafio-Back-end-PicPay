package com.develop.app.modules.transaction.DTO;

import java.math.BigDecimal;
import java.util.UUID;

public record CreatedTransferDTO(
  BigDecimal value,
  UUID receiverID,
  UUID sendID
) {
  
}

  // @Id
  // @GeneratedValue(strategy = GenerationType.UUID)
  // private UUID id;
  // private BigDecimal amout;
  // @ManyToOne
  // @JoinColumn(name="receiver_id")
  // private UserEntity receiver;
  // @ManyToOne
  // @JoinColumn(name="send_id")
  // private UserEntity send;
  // private LocalDateTime timesTamp;