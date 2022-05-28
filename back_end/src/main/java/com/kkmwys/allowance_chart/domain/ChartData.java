package com.kkmwys.allowance_chart.domain;

import com.kkmwys.allowance_chart.data.dto.ChartDataDto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

  @OneToMany(mappedBy = "chartData")
  private List<DataCategory> dataCategories;

  private int money;

  private String itemName;

  private String memo;

  private LocalDateTime localDateTime;

  @Builder
  public ChartData(Long id, int money, String itemName, String memo, LocalDateTime localDateTime){
    this.id = id;
    this.money = money;
    this.itemName = itemName;
    this.memo = memo;
    this.localDateTime = localDateTime;
    this.dataCategories = new ArrayList<>();
  }

  public void setDataCategory(List<DataCategory> dataCategory) {
    this.dataCategories = dataCategory;
  }

  public void updateChartData(ChartDataDto chartDataDto) {
    this.money = chartDataDto.getMoney();
    this.itemName = chartDataDto.getItemName();
  }

  public void addDataCategory(DataCategory dataCategory) {
    this.dataCategories.add(dataCategory);
  }


  @Override
  public String toString() {
    return getClass().getSimpleName() + "(" +
        "id = " + id + ", " +
        "money = " + money + ", " +
        "itemName = " + itemName + ", " +
        "memo = " + memo + ", " +
        "localDateTime = " + localDateTime + ")";
  }
}

