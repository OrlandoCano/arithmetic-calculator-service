package com.calculator.arithmetic_calculator.v1.randomstring.strategy;

import static com.calculator.arithmetic_calculator.v1.constants.ArithmeticCalculatorConstants.INSUFFICIENT_CREDITS_ERROR;
import static com.calculator.arithmetic_calculator.v1.constants.OperationType.RANDOM_STRING;

import com.calculator.arithmetic_calculator.v1.exception.InsufficientCreditsException;
import com.calculator.arithmetic_calculator.v1.operation.service.OperationService;
import com.calculator.arithmetic_calculator.v1.record.model.RecordDto;
import com.calculator.arithmetic_calculator.v1.record.service.RecordService;
import com.calculator.arithmetic_calculator.v1.request.BaseOperationRequest;
import com.calculator.arithmetic_calculator.v1.strategy.OperationStrategy;
import com.calculator.arithmetic_calculator.v1.user.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RandomStringStrategy extends OperationStrategy {
  private final String RANDOM_STRING_URL =
      "https://www.random.org/strings/?num=1&len=20&digits=on&upperalpha=on&loweralpha=on&unique=on&format=plain&rnd=new";

  public RandomStringStrategy(
      OperationService operationService, RecordService recordService, UserService userService) {
    super(operationService, recordService, userService);
  }

  @Override
  public boolean isApplicable(BaseOperationRequest request) {
    return RANDOM_STRING == request.getOperationType();
  }

  @Override
  public String performOperation(BaseOperationRequest request) {
    RestTemplate restTemplate = new RestTemplate();
    String result = restTemplate.getForEntity(RANDOM_STRING_URL, String.class).getBody();
    RecordDto.Builder newRecord = createRecord(RANDOM_STRING);

    if (!operationService.sufficientCredits(request)) {

      String errorResponse =
          String.format(INSUFFICIENT_CREDITS_ERROR, request.getOperationType().name());
      newRecord.withOperationResponse(errorResponse);
      recordService.saveRecord(newRecord.build());
      throw new InsufficientCreditsException(errorResponse);
    }

    newRecord.withOperationResponse("Random String Generated Result=" + result);
    recordService.saveRecord(newRecord.build());

    return result;
  }
}
