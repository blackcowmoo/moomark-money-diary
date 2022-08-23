package com.kkmwys.allowance_chart.data.dto;

import com.kkmwys.allowance_chart.domain.ChartData;
import com.kkmwys.allowance_chart.utils.ModelMapperUtils;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChartDataDto {
  private Long id;
  private CategoryDto category;
  private int money;
  private String itemName;
  private String memo;
  private LocalDateTime informationTime;
  @Builder
  public ChartDataDto(ChartData chartData) {
    this.id = chartData.getId();
    this.itemName = chartData.getItemName();
    this.money = chartData.getMoney();
    this.memo = chartData.getMemo();
    this.informationTime = chartData.getInformationTime();
    this.category = CategoryDto.of(chartData.getCategory());
  }

  public static ChartDataDto of(ChartData chartData) {
     return ModelMapperUtils.getModelMapper().map(chartData, ChartDataDto.class);
  }
}
