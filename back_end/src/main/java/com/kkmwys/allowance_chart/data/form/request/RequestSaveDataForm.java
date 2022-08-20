package com.kkmwys.allowance_chart.data.form.request;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class RequestSaveDataForm {
  private String categoryName;
  private String itemName;
  private int money;
  private String memo;
  private LocalDateTime informationTime;
}
