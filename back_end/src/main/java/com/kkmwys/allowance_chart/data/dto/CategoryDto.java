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

  public CategoryDto (Category category) {
    this.id = category.getId();
    this.name = category.getName();
  }
}
