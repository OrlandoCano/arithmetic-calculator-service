package com.calculator.arithmetic_calculator.v1.exception;

public class SessionExpiredException extends RuntimeException {
  public SessionExpiredException(String msg) {
    super(msg);
  }
}
