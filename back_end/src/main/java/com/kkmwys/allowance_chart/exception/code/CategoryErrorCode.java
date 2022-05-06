package com.kkmwys.allowance_chart.exception.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryErrorCode {

  ALREADY_EXIST_CATEGORY(200000,"ALREADY_EXIST_CATEGORY"),
  CANNOT_FOUND_CATEGORY(200001, "CANNOT_FOUND_CATEGORY");

  private final int errorCode;
  private final String msg;
}
