package com.kkmwys.allowance_chart.service;

import com.kkmwys.allowance_chart.data.dto.CategoryDto;
import com.kkmwys.allowance_chart.domain.Category;
import com.kkmwys.allowance_chart.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class CategoryService {

  private final CategoryRepository categoryRepository;

  /**
   * 카테고리 정보 저장 함수
   *
   * @param categoryDto 카테고리 정보
   * @return 저장된 카테고리 정보
   */
  public CategoryDto saveCategory(CategoryDto categoryDto) {
    Category savedCategory = categoryRepository.save(new Category(categoryDto));
    return CategoryDto.convertToDto(savedCategory);
  }

  /**
   * 카테고리 정보 업데이트 함수
   * @param id 업데이트 하고자하는 카테고리 id
   * @param categoryDto 업데이트 카테고리 정보
   * @return 업데이트가 진행된 카테고리 정보
   */
  public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
    Category category = categoryRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Category is not found"));
    category.updateInfo(categoryDto);
    return CategoryDto.convertToDto(category);
  }
}
