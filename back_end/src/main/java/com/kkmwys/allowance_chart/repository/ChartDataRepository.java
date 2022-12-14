package com.kkmwys.allowance_chart.repository;

import com.kkmwys.allowance_chart.domain.Category;
import com.kkmwys.allowance_chart.domain.ChartData;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChartDataRepository extends JpaRepository<ChartData, Long> {
  List<ChartData> findChartDataByCategory(Category category);

  @Query(value = "select d from ChartData d JOIN d.category c WHERE c.type LIKE %?1%")
  List<ChartData> findChartDataByCategoryType(String type);

  @Query(value = "select d from ChartData d JOIN d.category c WHERE c.name LIKE %?1%")
  List<ChartData> findChartDataByCategoryName(String name);
}
