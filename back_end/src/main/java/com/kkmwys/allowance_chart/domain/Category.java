package com.kkmwys.allowance_chart.domain;

import com.kkmwys.allowance_chart.data.dto.CategoryDto;
import java.util.List;
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
@AllArgsConstructor
@NoArgsConstructor
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @OneToMany(mappedBy = "category")
  private List<DataCategory> dataCategory;

  public Category(CategoryDto categoryDto) {
    this.id = categoryDto.getId();
    this.name = categoryDto.getName();
  }

  public Category updateInfo(CategoryDto categoryDto) {
    this.name = categoryDto.getName();
    return this;
  }
}
