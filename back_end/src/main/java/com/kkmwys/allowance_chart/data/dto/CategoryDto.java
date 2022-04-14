package com.kkmwys.allowance_chart.data.dto;

import com.kkmwys.allowance_chart.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

  private Long id;
  private String name;

  public static CategoryDto convertToDto(Category category) {
    return CategoryDto.builder()
        .id(category.getId())
        .name(category.getName())
        .build();
  }
}
