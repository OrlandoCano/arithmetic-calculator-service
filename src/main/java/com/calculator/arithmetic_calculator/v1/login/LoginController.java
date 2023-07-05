package com.calculator.arithmetic_calculator.v1.login;

import com.calculator.arithmetic_calculator.v1.login.model.request.LoginRequest;
import com.calculator.arithmetic_calculator.v1.login.model.response.LoginResponse;
import com.calculator.arithmetic_calculator.v1.login.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class LoginController {
  private final UserDetailsService userDetailsService;
  private final AuthenticationManager authenticationManager;
  private final PasswordEncoder passwordEncoder;
  private final JwtUtil jwtUtil;

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              loginRequest.username(), loginRequest.password()));
    } catch (AuthenticationException e) {
      throw new BadCredentialsException("Invalid username or password");
    }

    UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.username());
    String token = jwtUtil.generateToken(userDetails);

    return ResponseEntity.ok(new LoginResponse(token));
  }
}
