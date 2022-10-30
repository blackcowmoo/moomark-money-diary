package com.kkmwys.allowance_chart.repository;

import com.kkmwys.allowance_chart.domain.Category;
import com.kkmwys.allowance_chart.domain.CategoryType;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@DataJpaTest(showSql = true)
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CategoryRepositoryTest {

  @Autowired
  private CategoryRepository categoryRepository;


  @Test
  @DisplayName("Category 정보 저장 테스트")
  void saveCategory() {
    Category category = Category.builder()
        .id(1L)
        .type(CategoryType.INCOME)
        .name("salary")
        .build();

    categoryRepository.save(category);
    Category savedData = categoryRepository.findById(1L).orElse(new Category());
    Assertions.assertThat(category.getId()).isEqualTo(savedData.getId());
    Assertions.assertThat(category.getName()).isEqualTo(savedData.getName());
    Assertions.assertThat(category.getType()).isEqualTo(savedData.getType());
  }

  @Test
  @DisplayName("Category type 기반 정보 조회 함수")
  void getCategoryById() {
    Category category = Category.builder()
        .id(1L)
        .type(CategoryType.INCOME)
        .name("salary")
        .build();

    Category secondCategory = Category.builder()
        .id(1L)
        .type(CategoryType.INCOME)
        .name("second")
        .build();

    categoryRepository.save(category);
    categoryRepository.save(secondCategory);

    List<Category> categories = categoryRepository.findCategoriesByType(CategoryType.INCOME);

    for (Category category1 : categories) {
      Assertions.assertThat(category1.getType()).isEqualTo(CategoryType.INCOME);
    }
  }
}