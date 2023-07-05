package com.calculator.arithmetic_calculator.v1.logout.multiplication.strategy;

import static com.calculator.arithmetic_calculator.v1.constants.ArithmeticCalculatorConstants.INSUFFICIENT_CREDITS_ERROR;
import static com.calculator.arithmetic_calculator.v1.constants.OperationType.MULTIPLICATION;

import com.calculator.arithmetic_calculator.v1.exception.InsufficientCreditsException;
import com.calculator.arithmetic_calculator.v1.operation.service.OperationService;
import com.calculator.arithmetic_calculator.v1.record.model.RecordDto;
import com.calculator.arithmetic_calculator.v1.record.service.RecordService;
import com.calculator.arithmetic_calculator.v1.request.BaseOperationRequest;
import com.calculator.arithmetic_calculator.v1.strategy.OperationStrategy;
import com.calculator.arithmetic_calculator.v1.user.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class MultiplicationStrategy extends OperationStrategy {
  public MultiplicationStrategy(
      OperationService operationService, RecordService recordService, UserService userService) {
    super(operationService, recordService, userService);
  }

  @Override
  public boolean isApplicable(BaseOperationRequest request) {
    return MULTIPLICATION == request.getOperationType();
  }

  @Override
  public String performOperation(BaseOperationRequest request) {
    double result = (request.getFirstOperand() * request.getSecondOperand());

    RecordDto.Builder newRecord = createRecord(MULTIPLICATION);

    if (!operationService.sufficientCredits(request)) {

      String errorResponse =
          String.format(INSUFFICIENT_CREDITS_ERROR, request.getOperationType().name());
      newRecord.withOperationResponse(errorResponse);
      recordService.saveRecord(newRecord.build());
      throw new InsufficientCreditsException(errorResponse);
    }

    newRecord.withOperationResponse("Multiplication Applied Result=" + result);
    recordService.saveRecord(newRecord.build());

    return "" + result;
  }
}
