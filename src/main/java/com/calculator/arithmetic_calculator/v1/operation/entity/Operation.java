package com.calculator.arithmetic_calculator.v1.operation.entity;

import com.calculator.arithmetic_calculator.v1.constants.OperationType;
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
@Table(name = "OPERATIONS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Operation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  private OperationType type;

  private Double cost;
}
