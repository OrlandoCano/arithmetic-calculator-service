package com.calculator.arithmetic_calculator.v1.logout.multiplication.model.request;

import static com.calculator.arithmetic_calculator.v1.constants.OperationType.MULTIPLICATION;

import com.calculator.arithmetic_calculator.v1.request.BaseOperationRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = MultiplicationRequest.Builder.class)
public class MultiplicationRequest extends BaseOperationRequest {

  @lombok.Builder(setterPrefix = "with", builderMethodName = "multiplicationRequestBuilder")
  public MultiplicationRequest(double firstOperand, double secondOperand) {
    super(firstOperand, secondOperand, MULTIPLICATION);
  }
}
