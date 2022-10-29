package com.kkmwys.allowance_chart.domain;

public enum CategoryType {
  INCOME("INCOME"),
  SPENDING("SPENDING");

  private String type;

  CategoryType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}
