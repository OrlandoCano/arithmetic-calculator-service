package com.calculator.arithmetic_calculator.v1.record.service;

import com.calculator.arithmetic_calculator.v1.record.entity.Record;
import com.calculator.arithmetic_calculator.v1.record.model.RecordDto;
import com.calculator.arithmetic_calculator.v1.record.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecordServiceImpl implements RecordService {
  private final RecordRepository repository;

  @Override
  public Page<RecordDto> loadRecordsPagination(int page, int size) {
    PageRequest pageRequest = PageRequest.of(page, size);

    return repository
        .findAllByEnabledIsTrue(pageRequest)
        .map(
            userRecord ->
                RecordDto.builder()
                    .withId(userRecord.getId())
                    .withOperationId(userRecord.getOperationId())
                    .withUserId(userRecord.getUserId())
                    .withAmount(userRecord.getAmount())
                    .withUserBalance(userRecord.getUserBalance())
                    .withOperationResponse(userRecord.getOperationResponse())
                    .withCreatedDate(userRecord.getCreatedDate())
                    .withEnabled(userRecord.isEnabled())
                    .build());
  }

  @Override
  public RecordDto loadLatestUserRecord(String username) {

    Record latestRecord =
        repository.findByUserIdOrderByCreatedDateDesc(username).stream().findFirst().orElseThrow();

    return RecordDto.builder()
        .withId(latestRecord.getId())
        .withOperationId(latestRecord.getOperationId())
        .withUserId(latestRecord.getUserId())
        .withAmount(latestRecord.getAmount())
        .withUserBalance(latestRecord.getUserBalance())
        .withOperationResponse(latestRecord.getOperationResponse())
        .withCreatedDate(latestRecord.getCreatedDate())
        .withEnabled(latestRecord.isEnabled())
        .build();
  }

  @Override
  public void saveRecord(RecordDto newRecord) {
    repository.save(
        new Record(
            null,
            newRecord.getOperationId(),
            newRecord.getUserId(),
            newRecord.getAmount(),
            newRecord.getUserBalance(),
            newRecord.getOperationResponse(),
            newRecord.getCreatedDate(),
            true));
  }

  @Override
  public void softDeleteRecord(Long id) {
    Record record = repository.findById(id).orElseThrow();
    record.setEnabled(false);
    repository.save(record);
  }
}
