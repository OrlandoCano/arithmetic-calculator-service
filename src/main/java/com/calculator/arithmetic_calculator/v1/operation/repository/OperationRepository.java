package com.calculator.arithmetic_calculator.v1.operation.repository;

import com.calculator.arithmetic_calculator.v1.constants.OperationType;
import com.calculator.arithmetic_calculator.v1.operation.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {
  Operation findByType(OperationType type);
}
