package com.kkmwys.allowance_chart.config;

import com.kkmwys.allowance_chart.domain.CategoryType;
import com.kkmwys.allowance_chart.exception.CategoryTypeException;
import com.kkmwys.allowance_chart.exception.code.CategoryTypeErrorCode;
import java.util.Objects;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Converter
@Slf4j
public class CategoryTypeConverter implements AttributeConverter<CategoryType, String> {


  @Override
  public String convertToDatabaseColumn(CategoryType attribute) {
    if(Objects.isNull(attribute))
      return null;

    return attribute.getType();
  }

  @SneakyThrows(IllegalAccessException.class)
  @Override
  public CategoryType convertToEntityAttribute(String dbData) {
    if(Objects.isNull(dbData))
        return null;
    try {
      return CategoryType.fromType(dbData);
    } catch (IllegalAccessException e) {
      log.error("IllegalAccessException \n{}", e.getMessage());
      throw new CategoryTypeException(CategoryTypeErrorCode.CATEGORY_TYPE_FAIL.getErrorCode(),
          CategoryTypeErrorCode.CATEGORY_TYPE_FAIL.getMsg());
    }
  }
}
