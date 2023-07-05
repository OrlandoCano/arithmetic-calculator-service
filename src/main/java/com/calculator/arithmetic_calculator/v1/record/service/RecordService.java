package com.calculator.arithmetic_calculator.v1.record.service;

import com.calculator.arithmetic_calculator.v1.record.model.RecordDto;
import org.springframework.data.domain.Page;

public interface RecordService {
  Page<RecordDto> loadRecordsPagination(int page, int size);

  RecordDto loadLatestUserRecord(String username);

  void saveRecord(RecordDto newRecord);

  void softDeleteRecord(Long id);
}
