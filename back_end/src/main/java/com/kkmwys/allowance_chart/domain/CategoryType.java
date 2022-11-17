package com.kkmwys.allowance_chart.domain;

import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public enum CategoryType {
  INCOME("INCOME"),
  SPENDING("SPENDING");

  private static final Map<String, CategoryType> stringToCategoryType =
      Stream.of(values()).collect(toMap(CategoryType::getType, e -> e));
  private final String type;

  CategoryType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public static CategoryType fromType(String type) throws IllegalAccessException {
    CategoryType categoryType = stringToCategoryType.get(type);
    if (Objects.isNull(categoryType)) {
      throw new IllegalAccessException("Category Type is wrong");
    }

    return categoryType;
  }
}
