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

  @ManyToOne(fetch = FetchType.EAGER)
  private ChartData chartData;

  @ManyToOne(fetch = FetchType.EAGER)
  private Category category;

  public static DataCategory createDataCategory(ChartData chartData, Category category) {
    DataCategory dataCategory = new DataCategory();
    dataCategory.setCategory(category);
    dataCategory.setChartData(chartData);
    return dataCategory;
  }

  public static DataCategory createDataCategory(ChartData chartData) {
    DataCategory dataCategory = new DataCategory();
    dataCategory.setChartData(chartData);
    return dataCategory;
  }

  public static DataCategory createDataCategory(Category category) {
    DataCategory dataCategory = new DataCategory();
    dataCategory.setCategory(category);
    return dataCategory;
  }

  public void setChartData(ChartData chartData) {
    this.chartData = chartData;
    chartData.addDataCategory(this);
  }

  public void setCategory(Category category) {
    this.category = category;
    category.addDataCategory(this);
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "(" +
        "id = " + id + ")";
  }
}


