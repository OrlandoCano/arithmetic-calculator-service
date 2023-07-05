package com.calculator.arithmetic_calculator.v1.addition.controller;

import static com.calculator.arithmetic_calculator.v1.constants.ArithmeticCalculatorConstants.ARITHMETIC_CALCULATOR_PATH;

import com.calculator.arithmetic_calculator.v1.addition.model.request.AdditionRequest;
import com.calculator.arithmetic_calculator.v1.facade.RequestFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping(ARITHMETIC_CALCULATOR_PATH)
public class AdditionController {
  private final RequestFacade requestFacade;

  @PostMapping("addition")
  public ResponseEntity<String> doOperation(@RequestBody AdditionRequest request) {
    String result = requestFacade.processRequest(request);

    return ResponseEntity.status(201).body(result);
  }
}
