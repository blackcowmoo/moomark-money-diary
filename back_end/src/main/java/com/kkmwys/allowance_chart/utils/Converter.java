package com.kkmwys.allowance_chart.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Converter {

  private Converter() throws IllegalAccessException {
    throw new IllegalAccessException("This class is util class");
  }

  public static LocalDate toLocalDate(String time) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return LocalDate.parse(time, formatter);
  }
  public static LocalDateTime toLocalDateTime(LocalDate time) {
    return time.atStartOfDay();
  }
}
