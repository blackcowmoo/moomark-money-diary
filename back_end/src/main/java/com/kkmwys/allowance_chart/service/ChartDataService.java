package com.kkmwys.allowance_chart.service;

import com.kkmwys.allowance_chart.data.dto.CategoryDto;
import com.kkmwys.allowance_chart.data.dto.ChartDataDto;
import com.kkmwys.allowance_chart.domain.Category;
import com.kkmwys.allowance_chart.domain.ChartData;
import com.kkmwys.allowance_chart.domain.DataCategory;
import com.kkmwys.allowance_chart.exception.CategoryException;
import com.kkmwys.allowance_chart.exception.ChartDataException;
import com.kkmwys.allowance_chart.exception.code.CategoryErrorCode;
import com.kkmwys.allowance_chart.exception.code.ChartDataErrorCode;
import com.kkmwys.allowance_chart.repository.CategoryRepository;
import com.kkmwys.allowance_chart.repository.ChartDataRepository;
import com.kkmwys.allowance_chart.repository.DataCategoryRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ChartDataService {

  private final ChartDataRepository chartDataRepository;
  private final CategoryRepository categoryRepository;
  private final DataCategoryRepository dataCategoryRepository;

  /***** SAVE *****/

  @Transactional
  public ChartDataDto saveChartData(ChartDataDto chartDataDto)
      throws CategoryException {

    Set<DataCategory> dataCategorySet = new HashSet<>();
    // check category
    for (CategoryDto categoryDto : chartDataDto.getCategoryDtoSet()) {
      Category category = categoryRepository.findById(categoryDto.getId()).orElseThrow(
          () -> new CategoryException(CategoryErrorCode.CANNOT_FOUND_CATEGORY.getErrorCode(),
              CategoryErrorCode.CANNOT_FOUND_CATEGORY.getMsg()));

      dataCategorySet.add(DataCategory.builder()
          .category(category).build());
    }

    ChartData chartData = ChartData.builder()
        .dataCategory(dataCategorySet)
        .itemName(chartDataDto.getItemName())
        .memo(chartDataDto.getMemo())
        .localDateTime(chartDataDto.getLocalDateTime())
        .money(chartDataDto.getMoney())
        .build();

    return new ChartDataDto(chartDataRepository.save(chartData));
  }

  /***** GET *****/

  public List<ChartDataDto> getAllChartData() {
    List<ChartData> chartDataList = chartDataRepository.findAll();
    return chartDataList.stream().map(ChartDataDto::new).collect(Collectors.toList());
  }

  public ChartDataDto getChartDataById(Long id) throws ChartDataException {
    ChartData chartData = chartDataRepository.findById(id).orElseThrow(
        () -> new ChartDataException(ChartDataErrorCode.CANNOT_FOUND_CHART_DATA.getErrorCode(),
            ChartDataErrorCode.CANNOT_FOUND_CHART_DATA.getMsg())
    );

    return new ChartDataDto(chartData);
  }

  public List<ChartDataDto> getChartDataListByCategory(CategoryDto categoryDto)
      throws CategoryException {
    Category category = categoryRepository.findCategoryByName(categoryDto.getName()).orElseThrow(
        () -> new CategoryException(CategoryErrorCode.CANNOT_FOUND_CATEGORY.getErrorCode(),
            CategoryErrorCode.CANNOT_FOUND_CATEGORY.getMsg()));

    List<DataCategory> dataCategoryList = dataCategoryRepository
        .findDataCategoriesByCategory(category);
    List<ChartData> chartDataList = dataCategoryList.stream()
        .map(DataCategory::getChartData)
        .collect(Collectors.toList());
    return chartDataList.stream().map(ChartDataDto::new).collect(Collectors.toList());
  }

  /***** UPDATE *****/
  @Transactional
  public ChartDataDto updateChartData(ChartDataDto chartDataDto) throws ChartDataException {
    ChartData chartData = chartDataRepository.findById(chartDataDto.getId()).orElseThrow(
        () -> new ChartDataException(ChartDataErrorCode.CANNOT_FOUND_CHART_DATA.getErrorCode(),
            ChartDataErrorCode.CANNOT_FOUND_CHART_DATA.getMsg())
    );

    chartData.updateChartData(chartDataDto);

    return new ChartDataDto(chartData);
  }

  /***** DELETE *****/
  @Transactional
  public void deleteChartData(Long id) throws ChartDataException {
    ChartData chartData = chartDataRepository.findById(id).orElseThrow(
        () -> new ChartDataException(ChartDataErrorCode.CANNOT_FOUND_CHART_DATA.getErrorCode(),
            ChartDataErrorCode.CANNOT_FOUND_CHART_DATA.getMsg())
    );
    chartDataRepository.delete(chartData);
  }
}
