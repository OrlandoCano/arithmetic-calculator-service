package com.calculator.arithmetic_calculator.v1.addition.model.request;

import static com.calculator.arithmetic_calculator.v1.constants.OperationType.ADDITION;

import com.calculator.arithmetic_calculator.v1.request.BaseOperationRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(
    builder =
        com.calculator.arithmetic_calculator.v1.addition.model.request.AdditionRequest.Builder
            .class)
public class AdditionRequest extends BaseOperationRequest {

  @lombok.Builder(setterPrefix = "with", builderMethodName = "additionRequestBuilder")
  public AdditionRequest(double firstOperand, double secondOperand) {
    super(firstOperand, secondOperand, ADDITION);
  }
}
