package com.calculator.arithmetic_calculator.v1.subtraction.model.request;

import static com.calculator.arithmetic_calculator.v1.constants.OperationType.SUBTRACTION;

import com.calculator.arithmetic_calculator.v1.request.BaseOperationRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = SubtractionRequest.Builder.class)
public class SubtractionRequest extends BaseOperationRequest {
  @lombok.Builder(setterPrefix = "with", builderMethodName = "subtractionRequestBuilder")
  public SubtractionRequest(double firstOperand, double secondOperand) {
    super(firstOperand, secondOperand, SUBTRACTION);
  }
}
