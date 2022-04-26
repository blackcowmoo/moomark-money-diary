package com.kkmwys.allowance_chart.domain;

import com.kkmwys.allowance_chart.data.dto.ChartDataDto;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChartData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany(mappedBy = "chartData")
  private Set<DataCategory> dataCategory;

  private int money;

  private String itemName;

  private String memo;

  private LocalDateTime localDateTime;

  public void updateChartData(ChartDataDto chartDataDto) {
    this.money = chartDataDto.getMoney();
    this.itemName = chartDataDto.getItemName();
  }

  public void addCategory(DataCategory dataCategory) {
    this.dataCategory.add(dataCategory);
    dataCategory.setChartData(this);
  }

  public ChartData (ChartDataDto chartDataDto) {
    this.money = chartDataDto.getMoney();
    this.localDateTime = chartDataDto.getLocalDateTime();
    this.memo = chartDataDto.getMemo();
    this.itemName = chartDataDto.getItemName();
  }
}
