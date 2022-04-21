package com.kkmwys.allowance_chart.exception;

public class ChartDataException extends Exception {

  private final int errorCode;

  public ChartDataException(int errorCode, String msg) {
    super(msg);
    this.errorCode = errorCode;
  }

  public int getErrorCode() {
    return this.errorCode;
  }
}
