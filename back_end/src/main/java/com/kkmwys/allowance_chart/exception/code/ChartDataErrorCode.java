package com.kkmwys.allowance_chart.exception.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ChartDataErrorCode implements MyErrorCode {

  ALREADY_EXIST_CHART_DATA(100000,"ALREADY_EXIST_CHART_DATA"),
  CANNOT_FOUND_CHART_DATA(100001, "CANNOT_FOUND_CHART_DATA");

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
