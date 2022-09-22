package com.kkmwys.allowance_chart.service;

import com.kkmwys.allowance_chart.domain.ChartData;
import com.kkmwys.allowance_chart.repository.ChartDataRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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


  public List<ChartData> getTotalIncomeWhileMonth(int month) {
    List<ChartData> chartDataList = chartDataRepository.findChartDataByCategoryType(INCOME);
    return chartDataList.stream()
        .filter(chartData -> chartData.getInformationTime().getDayOfMonth() == month)
        .collect(Collectors.toList());
  }

//  public void getTotalSpendingWhileMonth() {
//
//  }
}
