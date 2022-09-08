package com.kkmwys.allowance_chart.domain;

import com.kkmwys.allowance_chart.data.dto.ChartDataDto;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class ChartData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.EAGER)
  private Category category;

  private int money;

  private String itemName;

  private String memo;

  private LocalDate informationTime;

  @Builder
  public ChartData(Long id, int money, String itemName, String memo, LocalDate informationTime, Category category){
    this.id = id;
    this.money = money;
    this.itemName = itemName;
    this.memo = memo;
    this.informationTime = informationTime;
    this.category = category;
  }
  public void updateChartData(ChartDataDto chartDataDto) {
    this.money = chartDataDto.getMoney();
    this.itemName = chartDataDto.getItemName();
    this.category.updateInfo(chartDataDto.getCategory());
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "(" +
        "id = " + id + ", " +
        "money = " + money + ", " +
        "itemName = " + itemName + ", " +
        "memo = " + memo + ", " +
        "informationTime = " + informationTime + ")";
  }
}

