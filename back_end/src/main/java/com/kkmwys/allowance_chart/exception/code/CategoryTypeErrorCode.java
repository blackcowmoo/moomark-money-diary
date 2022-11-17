package com.kkmwys.allowance_chart.exception.code;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CategoryTypeErrorCode implements MyErrorCode {
  CATEGORY_TYPE_FAIL(300000, "CATEGORY_TYPE_FAIL");

  private final int errorCode;
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
