package com.calculator.arithmetic_calculator.v1.operation.service;

import com.calculator.arithmetic_calculator.v1.constants.OperationType;
import com.calculator.arithmetic_calculator.v1.operation.model.OperationDto;
import com.calculator.arithmetic_calculator.v1.request.BaseOperationRequest;
import java.util.List;

public interface OperationService {
  List<OperationDto> loadOperations();

  OperationDto loadOperation(OperationType operationType);

  boolean sufficientCredits(BaseOperationRequest request);
}
