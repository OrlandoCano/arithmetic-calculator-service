package com.calculator.arithmetic_calculator.v1.exception;

public class InsufficientCreditsException extends RuntimeException {
  public InsufficientCreditsException(String errorMsg) {
    super(errorMsg);
  }
}
