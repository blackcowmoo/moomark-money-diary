package com.kkmwys.allowance_chart.controller;

import com.kkmwys.allowance_chart.service.StatisticsService;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/statistics")
public class StatisticsController {

  private final StatisticsService statisticsService;

  @GetMapping("/income/{start}/{end}")
  public ResponseEntity<Integer> getTotalIncomeValue(@PathVariable String start,
      @PathVariable String end) {
    return ResponseEntity.ok(statisticsService.getTotalIncomeOverTime(start, end));
  }

  @GetMapping("/spending/{start}/{end}")
  public ResponseEntity<Integer> getTotalSpendingValue(@PathVariable String start,
      @PathVariable String end) {
    return ResponseEntity.ok(statisticsService.getTotalSpendingOverTime(start, end));
  }
}
