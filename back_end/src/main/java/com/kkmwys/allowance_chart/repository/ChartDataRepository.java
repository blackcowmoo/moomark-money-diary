package com.kkmwys.allowance_chart.repository;

import com.kkmwys.allowance_chart.domain.Category;
import com.kkmwys.allowance_chart.domain.ChartData;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChartDataRepository extends JpaRepository<ChartData, Long> {
  List<ChartData> findChartDataByCategory(Category category);
}
