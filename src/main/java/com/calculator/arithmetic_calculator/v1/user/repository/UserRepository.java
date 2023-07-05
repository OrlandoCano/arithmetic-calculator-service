package com.calculator.arithmetic_calculator.v1.user.repository;

import com.calculator.arithmetic_calculator.v1.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);
}
