package com.calculator.arithmetic_calculator.v1.randomstring.model.request;

import static com.calculator.arithmetic_calculator.v1.constants.OperationType.RANDOM_STRING;

import com.calculator.arithmetic_calculator.v1.request.BaseOperationRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = RandomStringRequest.Builder.class)
public class RandomStringRequest extends BaseOperationRequest {
  @lombok.Builder(setterPrefix = "with", builderMethodName = "randomStringRequestBuilder")
  public RandomStringRequest() {
    super(0, 0, RANDOM_STRING);
  }
}
