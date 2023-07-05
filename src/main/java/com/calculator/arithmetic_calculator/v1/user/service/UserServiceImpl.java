package com.calculator.arithmetic_calculator.v1.user.service;

import com.calculator.arithmetic_calculator.v1.user.entity.User;
import com.calculator.arithmetic_calculator.v1.user.model.UserDto;
import com.calculator.arithmetic_calculator.v1.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  @Override
  public UserDto loadCurrentUser() {
    String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
    User user = userRepository.findByUsername(currentUsername);
    return UserDto.builder()
        .withUsername(user.getUsername())
        .withPassword(user.getPassword())
        .withEnabled(user.getEnabled())
        .build();
  }
}
