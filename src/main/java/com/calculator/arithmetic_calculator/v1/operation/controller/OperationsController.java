package com.calculator.arithmetic_calculator.v1.operation.controller;

import static com.calculator.arithmetic_calculator.v1.constants.ArithmeticCalculatorConstants.ARITHMETIC_CALCULATOR_PATH;

import com.calculator.arithmetic_calculator.v1.operation.model.OperationDto;
import com.calculator.arithmetic_calculator.v1.operation.service.OperationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping(ARITHMETIC_CALCULATOR_PATH)
public class OperationsController {
  private final OperationService operationService;

  @GetMapping("operations")
  public ResponseEntity<List<OperationDto>> loadOperations() {
    return ResponseEntity.ok(operationService.loadOperations());
  }
}
