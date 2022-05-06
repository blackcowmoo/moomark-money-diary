package com.kkmwys.allowance_chart.exception.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ChartDataErrorCode {

  ALREADY_EXIST_CHART_DATA(100000,"ALREADY_EXIST_CHART_DATA"),
  CANNOT_FOUND_CHART_DATA(100001, "CANNOT_FOUND_CHART_DATA");

  private final int errorCode;
  private final String msg;
}
