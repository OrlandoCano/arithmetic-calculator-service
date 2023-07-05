package com.calculator.arithmetic_calculator.v1.addition.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import com.calculator.arithmetic_calculator.v1.addition.model.request.AdditionRequest;
import com.calculator.arithmetic_calculator.v1.division.model.request.DivisionRequest;
import com.calculator.arithmetic_calculator.v1.exception.InsufficientCreditsException;
import com.calculator.arithmetic_calculator.v1.logout.multiplication.model.request.MultiplicationRequest;
import com.calculator.arithmetic_calculator.v1.operation.model.OperationDto;
import com.calculator.arithmetic_calculator.v1.operation.service.OperationService;
import com.calculator.arithmetic_calculator.v1.randomstring.model.request.RandomStringRequest;
import com.calculator.arithmetic_calculator.v1.record.model.RecordDto;
import com.calculator.arithmetic_calculator.v1.record.service.RecordService;
import com.calculator.arithmetic_calculator.v1.squareroot.model.request.SquareRootRequest;
import com.calculator.arithmetic_calculator.v1.subtraction.model.request.SubtractionRequest;
import com.calculator.arithmetic_calculator.v1.user.model.UserDto;
import com.calculator.arithmetic_calculator.v1.user.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class AdditionStrategyTest {
  @Mock private OperationService operationService;
  @Mock private RecordService recordService;
  @Mock private UserService userService;

  private AdditionStrategy subject;
  private AdditionRequest request;
  private UserDto currentUser;
  private RecordDto latestRecord;
  private OperationDto operation;

  @BeforeEach
  public void init() {
    openMocks(this);
    subject = new AdditionStrategy(operationService, recordService, userService);
    request = new AdditionRequest(10.0, 5.0);
    currentUser = UserDto.builder().withUsername("ocano").build();
    latestRecord = RecordDto.builder().withUserBalance(100.0).build();
    operation = OperationDto.builder().withCost(1.5).build();
  }

  @Test
  void isApplicableForAddition() {
    assertTrue(subject.isApplicable(request));
  }

  @Test
  void isNotApplicableForSubtraction() {
    assertFalse(subject.isApplicable(new SubtractionRequest(0.0, 0.0)));
  }

  @Test
  void isNotApplicableForDivision() {
    assertFalse(subject.isApplicable(new DivisionRequest(0.0, 0.0)));
  }

  @Test
  void isNotApplicableForMultiplication() {
    assertFalse(subject.isApplicable(new MultiplicationRequest(0.0, 0.0)));
  }

  @Test
  void isNotApplicableForRandomString() {
    assertFalse(subject.isApplicable(new RandomStringRequest()));
  }

  @Test
  void isNotApplicableForSquareRoot() {
    assertFalse(subject.isApplicable(new SquareRootRequest(5.0)));
  }

  @Test
  void shouldReturnValidResultForOperation() {
    when(operationService.sufficientCredits(any())).thenReturn(true);
    when(userService.loadCurrentUser()).thenReturn(currentUser);
    when(recordService.loadLatestUserRecord(any())).thenReturn(latestRecord);
    when(operationService.loadOperation(any())).thenReturn(operation);
    String result = subject.performOperation(request);
    verify(recordService, times(1)).saveRecord(any());
    assertEquals("15.0", result);
  }

  @Test
  void shouldReturnInsufficientCreditsResultForOperation() {
    when(operationService.sufficientCredits(any())).thenReturn(false);
    when(userService.loadCurrentUser()).thenReturn(currentUser);
    when(recordService.loadLatestUserRecord(any())).thenReturn(latestRecord);
    when(operationService.loadOperation(any())).thenReturn(operation);
    Assertions.assertThrows(
        InsufficientCreditsException.class,
        () -> {
          subject.performOperation(request);
        });
    verify(recordService, times(1)).saveRecord(any());
  }
}
