package com.calculator.arithmetic_calculator.v1.user.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(setterPrefix = "with")
@Jacksonized
@Value
public class UserDto {
  String username;
  String password;
  Boolean enabled;
}
