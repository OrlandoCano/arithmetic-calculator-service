package com.calculator.arithmetic_calculator.v1.facade;

import com.calculator.arithmetic_calculator.v1.request.BaseOperationRequest;
import com.calculator.arithmetic_calculator.v1.strategy.OperationStrategy;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RequestFacade {
  private final List<OperationStrategy> operationStrategies;

  public String processRequest(BaseOperationRequest request) {
    return operationStrategies.stream()
        .filter(operationStrategy -> operationStrategy.isApplicable(request))
        .findFirst()
        .orElseThrow()
        .performOperation(request);
  }
}
