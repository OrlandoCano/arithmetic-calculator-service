package com.calculator.arithmetic_calculator.v1.operation.model;

import com.calculator.arithmetic_calculator.v1.constants.OperationType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(setterPrefix = "with")
@Jacksonized
@Value
public class OperationDto {
  Long id;
  OperationType type;
  Double cost;
}
