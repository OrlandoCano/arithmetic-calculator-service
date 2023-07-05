package com.calculator.arithmetic_calculator.v1.logout;

import static com.calculator.arithmetic_calculator.v1.constants.ArithmeticCalculatorConstants.ARITHMETIC_CALCULATOR_PATH;

import com.calculator.arithmetic_calculator.v1.login.util.JwtUtil;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(ARITHMETIC_CALCULATOR_PATH)
@CrossOrigin(
    origins = {"http://localhost:3000", "http://localhost:8080"},
    allowCredentials = "true")
public class LogoutController {

  private final JwtUtil jwtUtil;
  private final UserDetailsService userDetailsService;

  @PostMapping("/logout")
  public void logout() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String username = authentication.getName();
    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
    String token = jwtUtil.generateToken(userDetails);

    jwtUtil.extractAllClaims(token).put("exp", new Date(0));
  }
}
