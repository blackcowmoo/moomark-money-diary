package com.kkmwys.allowance_chart.domain;

import com.kkmwys.allowance_chart.config.CategoryTypeConverter;
import com.kkmwys.allowance_chart.data.dto.CategoryDto;
import java.util.List;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
//  @Enumerated(EnumType.STRING)
  @Convert(converter = CategoryTypeConverter.class)
  private CategoryType type;

  @OneToMany(mappedBy = "id")
  private List<ChartData> chartData;

  public Category(CategoryDto categoryDto) {
    this.id = categoryDto.getId();
    this.name = categoryDto.getName();
    this.type = categoryDto.getType();
  }

  public void updateInfo(CategoryDto categoryDto) {
    this.name = categoryDto.getName();
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "(" +
        "id = " + id +
        "name = " + name +
        "type = " + type + ")";
  }
}
