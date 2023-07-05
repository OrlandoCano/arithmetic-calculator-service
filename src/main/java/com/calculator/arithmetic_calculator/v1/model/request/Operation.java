package com.calculator.arithmetic_calculator.v1.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(setterPrefix = "with")
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
@Value
public class Operation {}
