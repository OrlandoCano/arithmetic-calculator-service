package com.calculator.arithmetic_calculator.v1.randomstring.controller;

import static com.calculator.arithmetic_calculator.v1.constants.ArithmeticCalculatorConstants.ARITHMETIC_CALCULATOR_PATH;

import com.calculator.arithmetic_calculator.v1.facade.RequestFacade;
import com.calculator.arithmetic_calculator.v1.randomstring.model.request.RandomStringRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping(ARITHMETIC_CALCULATOR_PATH)
public class RandomStringController {
  private final RequestFacade requestFacade;

  @PostMapping("random-string")
  public ResponseEntity<String> doOperation(RandomStringRequest request) {
    String result = requestFacade.processRequest(request);

    return ResponseEntity.ok(result);
  }
}
