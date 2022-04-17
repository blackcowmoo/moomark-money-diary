package com.kkmwys.allowance_chart.controller;

import com.kkmwys.allowance_chart.data.dto.CategoryDto;
import com.kkmwys.allowance_chart.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/category")
@RestController
@RequiredArgsConstructor
public class CategoryController {

  private final CategoryService categoryService;

  @Operation(summary = "test hello", description = "hello api example")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "OK !!"),
      @ApiResponse(responseCode = "400", description = "BAD REQUEST !!"),
      @ApiResponse(responseCode = "404", description = "NOT FOUND !!"),
      @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR !!")
  })
  public ResponseEntity<List<CategoryDto>> getCategoryDtoList() {
    return ResponseEntity.ok(categoryService.getCategoryList());
  }

  @PostMapping("category/info")
  public ResponseEntity<CategoryDto> saveCategoryInfo(@RequestBody CategoryDto categoryDto) {
    return ResponseEntity.ok(categoryService.saveCategory(categoryDto));
  }

}
