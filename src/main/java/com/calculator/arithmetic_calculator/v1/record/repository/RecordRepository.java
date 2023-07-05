package com.calculator.arithmetic_calculator.v1.record.repository;

import com.calculator.arithmetic_calculator.v1.record.entity.Record;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {
  List<Record> findByUserIdOrderByCreatedDateDesc(String userId);

  Page<Record> findAllByEnabledIsTrue(Pageable pageable);
}
