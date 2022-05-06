package com.kkmwys.allowance_chart.repository;

import com.kkmwys.allowance_chart.domain.ChartData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChartDataRepository extends JpaRepository<ChartData, Long> {

}
