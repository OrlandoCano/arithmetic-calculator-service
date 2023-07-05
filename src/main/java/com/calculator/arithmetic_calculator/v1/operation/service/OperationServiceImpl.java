package com.calculator.arithmetic_calculator.v1.operation.service;

import com.calculator.arithmetic_calculator.v1.constants.OperationType;
import com.calculator.arithmetic_calculator.v1.operation.entity.Operation;
import com.calculator.arithmetic_calculator.v1.operation.model.OperationDto;
import com.calculator.arithmetic_calculator.v1.operation.repository.OperationRepository;
import com.calculator.arithmetic_calculator.v1.record.model.RecordDto;
import com.calculator.arithmetic_calculator.v1.record.service.RecordService;
import com.calculator.arithmetic_calculator.v1.request.BaseOperationRequest;
import com.calculator.arithmetic_calculator.v1.user.model.UserDto;
import com.calculator.arithmetic_calculator.v1.user.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {
  private final OperationRepository operationRepository;
  private final UserService userService;
  private final RecordService recordService;

  @Override
  public List<OperationDto> loadOperations() {
    return operationRepository.findAll().stream()
        .map(
            operation ->
                OperationDto.builder()
                    .withId(operation.getId())
                    .withCost(operation.getCost())
                    .withType(operation.getType())
                    .build())
        .collect(Collectors.toList());
  }

  @Override
  public OperationDto loadOperation(OperationType operationType) {
    Operation operation = operationRepository.findByType(operationType);
    return OperationDto.builder()
        .withType(operation.getType())
        .withCost(operation.getCost())
        .withId(operation.getId())
        .build();
  }

  @Override
  public boolean sufficientCredits(BaseOperationRequest request) {
    UserDto currentUser = userService.loadCurrentUser();
    OperationDto operation = loadOperation(request.getOperationType());
    RecordDto latestUserRecord = recordService.loadLatestUserRecord(currentUser.getUsername());

    return (latestUserRecord.getUserBalance() - operation.getCost()) >= 0;
  }
}
