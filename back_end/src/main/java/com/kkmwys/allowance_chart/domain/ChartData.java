package com.kkmwys.allowance_chart.domain;

import com.kkmwys.allowance_chart.data.dto.ChartDataDto;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChartData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany(mappedBy = "chartData")
  private Set<DataCategory> dataCategory;

  private int usedMoney;

  private String usedItems;

  private LocalDateTime localDateTime;

}
