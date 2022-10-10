package com.kkmwys.allowance_chart.service;

import com.kkmwys.allowance_chart.repository.ChartDataRepository;
import com.kkmwys.allowance_chart.utils.Converter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StatisticsService {

  private final ChartDataRepository chartDataRepository;
  private static final String INCOME = "income";
  private static final String SPENDING = "spending";

  public int getTotalIncomeOverTime(String start, String end) {
    return chartDataRepository.findChartDataByCategoryTypeAndInformationTimeBetween(
        INCOME, Converter.toLocalDate(start), Converter.toLocalDate(end)
    );
  }

  public int getTotalSpendingOverTime(String start, String end) {
    return chartDataRepository.findChartDataByCategoryTypeAndInformationTimeBetween(
        SPENDING, Converter.toLocalDate(start), Converter.toLocalDate(end)
    );
  }
}
