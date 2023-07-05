package com.calculator.arithmetic_calculator.v1.record.controller;

import static com.calculator.arithmetic_calculator.v1.constants.ArithmeticCalculatorConstants.ARITHMETIC_CALCULATOR_PATH;

import com.calculator.arithmetic_calculator.v1.record.model.RecordDto;
import com.calculator.arithmetic_calculator.v1.record.service.RecordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping(ARITHMETIC_CALCULATOR_PATH)
@Log
@CrossOrigin(
    origins = {"http://localhost:3000", "http://localhost:8080"},
    allowCredentials = "true")
public class UserRecordController {
  private final RecordService recordService;

  @GetMapping("records")
  public ResponseEntity<Page<RecordDto>> loadRecords(
      @RequestParam int page, @RequestParam int size) {

    return ResponseEntity.ok(recordService.loadRecordsPagination(page, size));
  }

  @DeleteMapping("records/{id}")
  public ResponseEntity<?> softDeleteRecord(@PathVariable Long id) {
    recordService.softDeleteRecord(id);
    return ResponseEntity.noContent().build();
  }
}
