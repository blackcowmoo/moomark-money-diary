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

  private static final String CATEGORY_NAME = "salary";

  @Test
  @DisplayName("Category 정보 ID 기반 조회 테스트")
  void saveCategory() {
    Category category = Category.builder()
        .id(1L)
        .type(CategoryType.INCOME)
        .name(CATEGORY_NAME)
        .build();

    categoryRepository.save(category);
    Category savedData = categoryRepository.findById(1L).orElse(new Category());
    Assertions.assertThat(category.getId()).isEqualTo(savedData.getId());
    Assertions.assertThat(category.getName()).isEqualTo(savedData.getName());
    Assertions.assertThat(category.getType()).isEqualTo(savedData.getType());
  }

  @Test
  @DisplayName("Category 정보 타입 기반 조회 테스트")
  void getCategoryByType() {
    Category firstCategory = Category.builder()
        .id(1L)
        .type(CategoryType.INCOME)
        .name("First Category")
        .build();
    Category secondCategory = Category.builder()
        .id(1L)
        .type(CategoryType.INCOME)
        .name("Second Category")
        .build();
    Category thirdCategory = Category.builder()
        .id(1L)
        .type(CategoryType.SPENDING)
        .name("Third Category")
        .build();

    categoryRepository.save(firstCategory);
    categoryRepository.save(secondCategory);
    categoryRepository.save(thirdCategory);

    List<Category> savedCategoryList = categoryRepository.findCategoriesByType(CategoryType.INCOME);

    Assertions.assertThat(savedCategoryList).hasSize(2);
    for (Category category : savedCategoryList) {
      Assertions.assertThat(category.getType()).isEqualTo(CategoryType.INCOME);
    }
  }

}