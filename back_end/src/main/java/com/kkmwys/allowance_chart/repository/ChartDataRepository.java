package com.kkmwys.allowance_chart.repository;

import com.kkmwys.allowance_chart.domain.ChartData;
import com.kkmwys.allowance_chart.domain.DataCategory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChartDataRepository extends JpaRepository<ChartData, Long> {

  public List<ChartData> getChartDataByDataCategoryOrderByLocalDateTime(DataCategory dataCategory);
}
