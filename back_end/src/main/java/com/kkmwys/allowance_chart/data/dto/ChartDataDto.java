package com.kkmwys.allowance_chart.data.dto;

import com.kkmwys.allowance_chart.domain.ChartData;
import com.kkmwys.allowance_chart.domain.DataCategory;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChartDataDto {

  private Long id;
  private List<CategoryDto> dataCategories = new ArrayList<>();
  private int money;
  private String itemName;
  private String memo;
  private LocalDateTime localDateTime;

  @Builder
  public ChartDataDto(ChartData chartData) {
    this.id = chartData.getId();
    this.itemName = chartData.getItemName();
    this.money = chartData.getMoney();
    this.memo = chartData.getMemo();
    this.localDateTime = chartData.getLocalDateTime();
    this.dataCategories = chartData.getDataCategories().stream()
        .map(DataCategory::getCategory)
        .map(CategoryDto::convertToDto)
        .collect(Collectors.toList());
  }
}
