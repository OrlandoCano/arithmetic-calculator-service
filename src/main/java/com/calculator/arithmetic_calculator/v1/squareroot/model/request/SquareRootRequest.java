package com.calculator.arithmetic_calculator.v1.squareroot.model.request;

import static com.calculator.arithmetic_calculator.v1.constants.OperationType.SQUARE_ROOT;

import com.calculator.arithmetic_calculator.v1.request.BaseOperationRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(
    builder =
        com.calculator.arithmetic_calculator.v1.squareroot.model.request.SquareRootRequest.Builder
            .class)
public class SquareRootRequest extends BaseOperationRequest {
  @lombok.Builder(setterPrefix = "with", builderMethodName = "squareRootRequestBuilder")
  public SquareRootRequest(double firstOperand) {
    super(firstOperand, 0, SQUARE_ROOT);
  }
}
