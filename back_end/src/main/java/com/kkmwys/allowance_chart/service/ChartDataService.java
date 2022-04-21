package com.kkmwys.allowance_chart.service;

import com.kkmwys.allowance_chart.data.dto.ChartDataDto;
import com.kkmwys.allowance_chart.domain.ChartData;
import com.kkmwys.allowance_chart.exception.ChartDataException;
import com.kkmwys.allowance_chart.exception.code.ChartDataErrorCode;
import com.kkmwys.allowance_chart.repository.ChartDataRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChartDataService {

  private final ChartDataRepository chartDataRepository;

  /***** SAVE *****/

  public ChartDataDto saveChartData(ChartDataDto chartDataDto) throws ChartDataException {

    if (chartDataRepository.findById(chartDataDto.getId()).isPresent()) {
      throw new ChartDataException(ChartDataErrorCode.ALREADY_EXIST_CHART_DATA.getErrorCode(),
          ChartDataErrorCode.ALREADY_EXIST_CHART_DATA.getMsg());
    }

    ChartData chartData = ChartData.builder()
        .usedItems(chartDataDto.getUsedItems())
        .usedMoney(chartDataDto.getUsedMoney())
        .localDateTime(chartDataDto.getLocalDateTime())
        .build();

    ChartData savedData = chartDataRepository.save(chartData);
    return new ChartDataDto(savedData);
  }

  /***** GET *****/

  public List<ChartDataDto> getAllChartData() {
    List<ChartData> chartDataList = chartDataRepository.findAll();
    return chartDataList.stream().map(ChartDataDto::new).collect(Collectors.toList());
  }
}
