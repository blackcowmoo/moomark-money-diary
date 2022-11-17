package com.kkmwys.allowance_chart.exception.code;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CategoryErrorCode implements MyErrorCode {

  ALREADY_EXIST_CATEGORY(200000, "ALREADY_EXIST_CATEGORY"),
  CANNOT_FOUND_CATEGORY(200001, "CANNOT_FOUND_CATEGORY"),

  INVALID_CATEGORY_TYPE(200002, "INVALID_CATEGORY_TYPE");
  private final Integer errorCode;
  private final String msg;

  @Override
  public String getMsg() {
    return msg;
  }

  @Override
  public Integer getErrorCode() {
    return errorCode;
  }
}
