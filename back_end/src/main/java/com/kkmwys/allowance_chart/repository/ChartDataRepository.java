package com.kkmwys.allowance_chart.repository;

import com.kkmwys.allowance_chart.domain.Category;
import com.kkmwys.allowance_chart.domain.ChartData;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChartDataRepository extends JpaRepository<ChartData, Long> {

  List<ChartData> findChartDataByCategory(Category category);

  @Query(value = "select SUM(d.money) from ChartData d Join d.category c WHERE c.type LIKE %?1% AND d.informationTime between ?2 AND ?3")
  int findChartDataByCategoryTypeAndInformationTimeBetween(String type,
      LocalDate informationTime,
      LocalDate informationTime2);

  @Query(value = "select d from ChartData d JOIN d.category c WHERE c.type LIKE %?1%")
  List<ChartData> findChartDataByCategoryType(String type);

  @Query(value = "select d from ChartData d JOIN d.category c WHERE c.name LIKE %?1%")
  List<ChartData> findChartDataByCategoryName(String name);

}
