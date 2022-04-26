package com.kkmwys.allowance_chart.data.dto;

import com.kkmwys.allowance_chart.domain.ChartData;
import com.kkmwys.allowance_chart.domain.DataCategory;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChartDataDto {

  private Long id;
  private Set<CategoryDto> categoryDtoSet;
  private int money;
  private String itemName;
  private String memo;
  private LocalDateTime localDateTime;

  public ChartDataDto(ChartData chartData) {
    this.id = chartData.getId();
    this.itemName = chartData.getItemName();
    this.money = chartData.getMoney();
    this.memo = chartData.getMemo();
    this.localDateTime = chartData.getLocalDateTime();
    this.categoryDtoSet = chartData.getDataCategory().stream()
        .map(DataCategory::getCategory)
        .filter(Objects::nonNull)
        .map(CategoryDto::new)
        .collect(Collectors.toSet());
  }

}
