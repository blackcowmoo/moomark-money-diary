package com.kkmwys.allowance_chart.service;

import com.kkmwys.allowance_chart.domain.ChartData;
import com.kkmwys.allowance_chart.repository.ChartDataRepository;
import com.kkmwys.allowance_chart.utils.Converter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
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

  public int getTotalIncomeWhileMonth(LocalDate start, LocalDate end) {
    int result = 0;
    LocalDateTime startTime = Converter.toLocalDateTime(start);
    LocalDateTime endTime = Converter.toLocalDateTime(end);
    List<ChartData> chartDataList = chartDataRepository.findChartDataByInformationTimeBetween(startTime, endTime);

    for (ChartData chartData : chartDataList) {
      result += chartData.getMoney();
    }

    return result;
  }
}
