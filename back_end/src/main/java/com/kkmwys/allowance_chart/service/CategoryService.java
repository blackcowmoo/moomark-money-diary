package com.kkmwys.allowance_chart.service;

import com.kkmwys.allowance_chart.data.dto.CategoryDto;
import com.kkmwys.allowance_chart.domain.Category;
import com.kkmwys.allowance_chart.domain.CategoryType;
import com.kkmwys.allowance_chart.exception.CategoryException;
import com.kkmwys.allowance_chart.exception.code.CategoryErrorCode;
import com.kkmwys.allowance_chart.repository.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryService {

  private final CategoryRepository categoryRepository;

  /**
   * 카테고리 정보 저장 함수
   *
   * @param categoryDto 카테고리 정보
   * @return 저장된 카테고리 정보
   */
  @Transactional
  public CategoryDto saveCategory(CategoryDto categoryDto) throws CategoryException {

    if (categoryRepository.findCategoryByName(categoryDto.getName()).isPresent()) {
      throw new CategoryException(CategoryErrorCode.ALREADY_EXIST_CATEGORY.getErrorCode(),
          CategoryErrorCode.ALREADY_EXIST_CATEGORY.getMsg());
    }

    Category savedCategory = categoryRepository.save(new Category(categoryDto));
    return CategoryDto.of(savedCategory);
  }

  public List<CategoryDto> getCategoryList() {
    List<Category> categories = categoryRepository.findAll();
    return categories.stream().map(CategoryDto::of).collect(Collectors.toList());
  }

  public List<CategoryDto> getCategoryListByType(CategoryType type) {
    List<Category> categories = categoryRepository.findCategoriesByType(type);
    if(categories == null || categories.isEmpty()) {
      return new ArrayList<>();
    }
    return categories.stream().map(CategoryDto::of).collect(Collectors.toList());
  }


  /**
   * 카테고리 정보 업데이트 함수
   *
   * @param id          업데이트 하고자하는 카테고리 id
   * @param categoryDto 업데이트 카테고리 정보
   * @return 업데이트가 진행된 카테고리 정보
   */
  @Transactional
  public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
    Category category = null;
    try {
      category = categoryRepository.findById(id).orElseThrow(
          () -> new CategoryException(CategoryErrorCode.CANNOT_FOUND_CATEGORY.getErrorCode(),
              CategoryErrorCode.CANNOT_FOUND_CATEGORY.getMsg()));
    } catch (CategoryException e) {
      e.printStackTrace();
    }
    Objects.requireNonNull(category).updateInfo(categoryDto);
    return CategoryDto.of(category);
  }

  /**
   * Category 삭제 함수
   *
   * @param id 카테고리 ID
   * @return 삭제 성공 여부
   */
  @Transactional
  public boolean deleteCategory(Long id) {
    Category category;
    try {
      category = categoryRepository.findById(id).orElseThrow(
          () -> new CategoryException(CategoryErrorCode.CANNOT_FOUND_CATEGORY.getErrorCode(),
              CategoryErrorCode.CANNOT_FOUND_CATEGORY.getMsg()));
    } catch (CategoryException e) {
      e.printStackTrace();
      return false;
    }
    categoryRepository.delete(category);
    return true;
  }

}
