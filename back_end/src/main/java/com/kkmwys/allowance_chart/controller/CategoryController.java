package com.kkmwys.allowance_chart.controller;

import com.kkmwys.allowance_chart.data.dto.CategoryDto;
import com.kkmwys.allowance_chart.domain.CategoryType;
import com.kkmwys.allowance_chart.exception.CategoryException;
import com.kkmwys.allowance_chart.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/category")
@RestController
@RequiredArgsConstructor
public class CategoryController {

  private final CategoryService categoryService;

  @Operation(summary = "Get category list", description = "Get category list")
  @ApiResponse(responseCode = "200", description = "OK !!")
  @ApiResponse(responseCode = "400", description = "BAD REQUEST !!")
  @ApiResponse(responseCode = "404", description = "NOT FOUND !!")
  @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR !!")
  @GetMapping("/list")
  public ResponseEntity<List<CategoryDto>> getCategoryDtoList() {
    return ResponseEntity.ok(categoryService.getCategoryList());
  }

  @Operation(summary = "Get category list by income", description = "Get category list by income")
  @ApiResponse(responseCode = "200", description = "OK !!")
  @ApiResponse(responseCode = "400", description = "BAD REQUEST !!")
  @ApiResponse(responseCode = "404", description = "NOT FOUND !!")
  @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR !!")
  @GetMapping("/list/income")
  public ResponseEntity<List<CategoryDto>> getIncomeCategoryDtoList() {
    return ResponseEntity.ok(categoryService.getCategoryListByType(CategoryType.INCOME));
  }

  @Operation(summary = "Get category list by spending", description = "Get category list by spending")
  @ApiResponse(responseCode = "200", description = "OK !!")
  @ApiResponse(responseCode = "400", description = "BAD REQUEST !!")
  @ApiResponse(responseCode = "404", description = "NOT FOUND !!")
  @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR !!")
  @GetMapping("/list/spending")
  public ResponseEntity<List<CategoryDto>> getSpendingCategoryDtoList() {
    return ResponseEntity.ok(categoryService.getCategoryListByType(CategoryType.SPENDING));
  }

  @Operation(summary = "Save category info", description = "Save category info")
  @ApiResponse(responseCode = "200", description = "OK !!")
  @ApiResponse(responseCode = "400", description = "BAD REQUEST !!")
  @ApiResponse(responseCode = "404", description = "NOT FOUND !!")
  @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR !!")
  @PostMapping("/info")
  public ResponseEntity<CategoryDto> saveCategoryInfo(@RequestBody CategoryDto categoryDto) {
    try {
      return ResponseEntity.ok(categoryService.saveCategory(categoryDto));
    } catch (CategoryException e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
  }

  @Operation(summary = "Update category info", description = "Update category info")
  @ApiResponse(responseCode = "200", description = "OK !!")
  @ApiResponse(responseCode = "400", description = "BAD REQUEST !!")
  @ApiResponse(responseCode = "404", description = "NOT FOUND !!")
  @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR !!")
  @PutMapping("/info/{id}")
  public ResponseEntity<CategoryDto> updateCategoryInfo(@PathVariable Long id,
      @RequestBody CategoryDto categoryDto) {
    return ResponseEntity.ok(categoryService.updateCategory(id, categoryDto));
  }

  @Operation(summary = "Delete category info", description = "Delete category info")
  @ApiResponse(responseCode = "200", description = "OK !!")
  @ApiResponse(responseCode = "400", description = "BAD REQUEST !!")
  @ApiResponse(responseCode = "404", description = "NOT FOUND !!")
  @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR !!")
  @DeleteMapping("/info/{id}")
  public ResponseEntity<Boolean> deleteCategoryInfo(@PathVariable Long id) {
    return ResponseEntity.ok(categoryService.deleteCategory(id));
  }
}
