package com.kkmwys.allowance_chart.repository;

import com.kkmwys.allowance_chart.domain.Category;
import com.kkmwys.allowance_chart.domain.DataCategory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataCategoryRepository extends JpaRepository<DataCategory, Long> {
  List<DataCategory> findDataCategoriesByCategory(Category category);
}
