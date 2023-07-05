package com.calculator.arithmetic_calculator.v1.logout.multiplication.controller;

import static com.calculator.arithmetic_calculator.v1.constants.ArithmeticCalculatorConstants.ARITHMETIC_CALCULATOR_PATH;

import com.calculator.arithmetic_calculator.v1.facade.RequestFacade;
import com.calculator.arithmetic_calculator.v1.logout.multiplication.model.request.MultiplicationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping(ARITHMETIC_CALCULATOR_PATH)
@CrossOrigin("http://localhost:3000")
public class MultiplicationController {
  private final RequestFacade requestFacade;

  @PostMapping("multiplication")
  public ResponseEntity<String> doOperation(@RequestBody MultiplicationRequest request) {
    String result = requestFacade.processRequest(request);

    return ResponseEntity.status(201).body(result);
  }
}
