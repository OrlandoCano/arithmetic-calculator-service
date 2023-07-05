package com.calculator.arithmetic_calculator.v1.login.util;

import com.calculator.arithmetic_calculator.v1.exception.SessionExpiredException;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final UserDetailsService userDetailsService;
  private final JwtUtil jwtUtil;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws ServletException, IOException {

    String jwtToken = extractJwtTokenFromRequest(request);
    if (StringUtils.hasText(jwtToken)) {
      try {
        String username = jwtUtil.extractUsername(jwtToken);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (jwtUtil.validateToken(jwtToken, userDetails)) {
          UsernamePasswordAuthenticationToken authenticationToken =
              new UsernamePasswordAuthenticationToken(
                  userDetails, null, userDetails.getAuthorities());
          SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
      } catch (ExpiredJwtException e) {
        throw new SessionExpiredException("Your session is expired login again");
      }
    }

    chain.doFilter(request, response);
  }

  private String extractJwtTokenFromRequest(HttpServletRequest request) {
    String bearerToken = request.getHeader("Authorization");
    if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
      return bearerToken.substring(7);
    }
    return null;
  }
}
