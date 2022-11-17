package com.kkmwys.allowance_chart.exception;

public class CategoryTypeException extends IllegalAccessException {

  private final int errorCode;

  public CategoryTypeException(int errorCode, String msg) {
    super(msg);
    this.errorCode = errorCode;
  }

  public int getErrorCode() {
    return this.errorCode;
  }
}
