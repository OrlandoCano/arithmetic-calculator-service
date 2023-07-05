package com.calculator.arithmetic_calculator.v1.division.model.request;

import static com.calculator.arithmetic_calculator.v1.constants.OperationType.DIVISION;

import com.calculator.arithmetic_calculator.v1.request.BaseOperationRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(
    builder =
        com.calculator.arithmetic_calculator.v1.division.model.request.DivisionRequest.Builder
            .class)
public class DivisionRequest extends BaseOperationRequest {

  @lombok.Builder(setterPrefix = "with", builderMethodName = "divisionRequestBuilder")
  public DivisionRequest(double firstOperand, double secondOperand) {
    super(firstOperand, secondOperand, DIVISION);
  }
}
