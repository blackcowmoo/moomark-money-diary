package com.kkmwys.allowance_chart.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DataCategory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  private ChartData chartData;

  @ManyToOne(fetch = FetchType.LAZY)
  private Category category;

  public static DataCategory createDataCategory(ChartData chartData, Category category) {
    DataCategory dataCategory = new DataCategory();
    dataCategory.setCategory(category);
    dataCategory.setChartData(chartData);
    return dataCategory;
  }

  public void setChartData(ChartData chartData) {
    this.chartData = chartData;
  }

  public void setCategory(Category category) {
    this.category = category;
  }
}


