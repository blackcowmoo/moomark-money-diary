package com.kkmwys.allowance_chart.repository;

import com.kkmwys.allowance_chart.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
