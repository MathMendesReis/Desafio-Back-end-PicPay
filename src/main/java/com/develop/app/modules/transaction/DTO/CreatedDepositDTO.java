package com.develop.app.modules.transaction.DTO;

import java.math.BigDecimal;
import java.util.UUID;

public record CreatedDepositDTO(
  BigDecimal value,
  UUID receivedId
) {}
 
