package com.calculator.arithmetic_calculator.v1.strategy;

import com.calculator.arithmetic_calculator.v1.constants.OperationType;
import com.calculator.arithmetic_calculator.v1.operation.model.OperationDto;
import com.calculator.arithmetic_calculator.v1.operation.service.OperationService;
import com.calculator.arithmetic_calculator.v1.record.model.RecordDto;
import com.calculator.arithmetic_calculator.v1.record.service.RecordService;
import com.calculator.arithmetic_calculator.v1.request.BaseOperationRequest;
import com.calculator.arithmetic_calculator.v1.user.model.UserDto;
import com.calculator.arithmetic_calculator.v1.user.service.UserService;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public abstract class OperationStrategy {
  protected final OperationService operationService;
  protected final RecordService recordService;
  protected final UserService userService;

  public abstract boolean isApplicable(BaseOperationRequest request);

  public abstract String performOperation(BaseOperationRequest request);

  public RecordDto.Builder createRecord(OperationType operationType) {
    UserDto currentUser = userService.loadCurrentUser();
    RecordDto latestUserRecord = recordService.loadLatestUserRecord(currentUser.getUsername());
    OperationDto operation = operationService.loadOperation(operationType);

    return RecordDto.builder()
        .withCreatedDate(LocalDateTime.now())
        .withOperationId(UUID.randomUUID())
        .withAmount(operation.getCost())
        .withUserBalance(latestUserRecord.getUserBalance() - operation.getCost())
        .withUserId(currentUser.getUsername());
  }
}
