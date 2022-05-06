package com.kkmwys.allowance_chart.exception;

public class CategoryException extends Exception {

  private final int errorCode;

  public CategoryException(int errorCode, String msg) {
    super(msg);
    this.errorCode = errorCode;
  }

  public int getErrorCode() {
    return this.errorCode;
  }
}
