package com.calculator.arithmetic_calculator.v1.addition.strategy;

import static com.calculator.arithmetic_calculator.v1.constants.ArithmeticCalculatorConstants.INSUFFICIENT_CREDITS_ERROR;
import static com.calculator.arithmetic_calculator.v1.constants.OperationType.ADDITION;

import com.calculator.arithmetic_calculator.v1.exception.InsufficientCreditsException;
import com.calculator.arithmetic_calculator.v1.operation.service.OperationService;
import com.calculator.arithmetic_calculator.v1.record.model.RecordDto;
import com.calculator.arithmetic_calculator.v1.record.service.RecordService;
import com.calculator.arithmetic_calculator.v1.request.BaseOperationRequest;
import com.calculator.arithmetic_calculator.v1.strategy.OperationStrategy;
import com.calculator.arithmetic_calculator.v1.user.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class AdditionStrategy extends OperationStrategy {
  public AdditionStrategy(
      OperationService operationService, RecordService recordService, UserService userService) {
    super(operationService, recordService, userService);
  }

  @Override
  public boolean isApplicable(BaseOperationRequest request) {
    return ADDITION == request.getOperationType();
  }

  @Override
  public String performOperation(BaseOperationRequest request) {

    double result = request.getFirstOperand() + request.getSecondOperand();
    RecordDto.Builder newRecord = createRecord(ADDITION);

    if (!operationService.sufficientCredits(request)) {

      String errorResponse =
          String.format(INSUFFICIENT_CREDITS_ERROR, request.getOperationType().name());
      newRecord.withOperationResponse(errorResponse);
      recordService.saveRecord(newRecord.build());
      throw new InsufficientCreditsException(errorResponse);
    }

    newRecord.withOperationResponse("Addition Applied Result=" + result);
    recordService.saveRecord(newRecord.build());

    return "" + result;
  }
}
