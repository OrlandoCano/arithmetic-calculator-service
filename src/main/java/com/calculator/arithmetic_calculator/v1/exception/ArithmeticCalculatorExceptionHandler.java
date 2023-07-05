package com.calculator.arithmetic_calculator.v1.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ArithmeticCalculatorExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = InsufficientCreditsException.class)
  public ResponseEntity<String> handleInsufficientCredits(RuntimeException exception) {
    return ResponseEntity.badRequest().body(exception.getMessage());
  }

  @ExceptionHandler(value = SessionExpiredException.class)
  public ResponseEntity<String> handleSessionExpired(RuntimeException exception) {
    return ResponseEntity.status(401).body(exception.getMessage());
  }
}
