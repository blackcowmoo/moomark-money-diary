package com.kkmwys.allowance_chart.data.dto;

import com.kkmwys.allowance_chart.domain.Category;
import com.kkmwys.allowance_chart.utils.ModelMapperUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

  private Long id;
  private String name;
  private String type;
  public static CategoryDto of(Category category) {
    if(category == null) {
      return new CategoryDto();
    }
    CategoryDto convertData = ModelMapperUtils.getModelMapper().map(category, CategoryDto.class);
    log.info("convertData : {}", convertData.toString());
    return convertData;
  }
}
