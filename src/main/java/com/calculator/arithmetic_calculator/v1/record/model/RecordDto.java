package com.calculator.arithmetic_calculator.v1.record.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(setterPrefix = "with")
@Jacksonized
@Value
public class RecordDto {
  Long id;
  UUID operationId;
  String userId;
  Double amount;
  Double userBalance;
  String operationResponse;
  LocalDateTime createdDate;
  Boolean enabled;
}
