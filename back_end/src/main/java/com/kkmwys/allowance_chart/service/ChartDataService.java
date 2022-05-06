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
public class ChartDataService {

  private final ChartDataRepository chartDataRepository;
  private final CategoryRepository categoryRepository;
  private final DataCategoryRepository dataCategoryRepository;

  /***** SAVE *****/

  @Transactional
  public ChartDataDto saveChartData(ChartDataDto chartDataDto)
      throws CategoryException {

    List<DataCategory> dataCategoryList = new ArrayList<>();
    // check category
    for (CategoryDto categoryDto : chartDataDto.getDataCategories()) {
      Category category = categoryRepository.findById(categoryDto.getId()).orElseThrow(
          () -> new CategoryException(CategoryErrorCode.CANNOT_FOUND_CATEGORY.getErrorCode(),
              CategoryErrorCode.CANNOT_FOUND_CATEGORY.getMsg()));

      DataCategory dataCategory = DataCategory.builder()
          .category(category)
          .build();
      dataCategoryList.add(dataCategory);
    }

    ChartData chartData = ChartData.builder()
        .itemName(chartDataDto.getItemName())
        .memo(chartDataDto.getMemo())
        .localDateTime(chartDataDto.getLocalDateTime())
        .money(chartDataDto.getMoney())
        .build();

    for (DataCategory dataCategory : dataCategoryList) {
      dataCategory.setChartData(chartData);
      dataCategoryRepository.save(dataCategory);
    }

    chartData.setDataCategory(dataCategoryList);
    ChartData savedChartData = chartDataRepository.save(chartData);
    return new ChartDataDto(savedChartData);
  }

  /***** GET *****/

  public List<ChartDataDto> getAllChartData() {
    List<ChartData> chartDataList = chartDataRepository.findAll();
    List<ChartDataDto> resultList = new ArrayList<>();
    for (var chartData : chartDataList) {
      resultList.add(new ChartDataDto(chartData));
    }

    return resultList;
  }

  public ChartDataDto getChartDataById(Long id) throws ChartDataException {
    ChartData chartData = chartDataRepository.findById(id).orElseThrow(
        () -> new ChartDataException(ChartDataErrorCode.CANNOT_FOUND_CHART_DATA.getErrorCode(),
            ChartDataErrorCode.CANNOT_FOUND_CHART_DATA.getMsg())
    );
    log.info("chart_data information {}", chartData.toString());
    for (var dataCategory : chartData.getDataCategories()) {
      log.info("Category information : {}", dataCategory.getCategory().toString());
    }
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
