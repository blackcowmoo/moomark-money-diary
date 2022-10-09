package com.kkmwys.allowance_chart.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Converter {

  private Converter() throws IllegalAccessException {
    throw new IllegalAccessException("This class is util class");
  }

  public static LocalDateTime toLocalDateTime(LocalDate time) {
    return time.atStartOfDay();
  }
}
