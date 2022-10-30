package com.kkmwys.allowance_chart.repository;

import com.kkmwys.allowance_chart.domain.Category;
import com.kkmwys.allowance_chart.domain.CategoryType;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
  public Optional<Category> findCategoryByName(String name);

  public List<Category> findCategoriesByType(CategoryType type);

}
