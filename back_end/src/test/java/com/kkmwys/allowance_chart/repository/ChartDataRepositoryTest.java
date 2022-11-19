package com.kkmwys.allowance_chart.repository;

import static org.junit.jupiter.api.Assertions.*;

import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest(showSql = true)
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
class ChartDataRepositoryTest {

  @Autowired
  private ChartDataRepository chartDataRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @BeforeEach
  void initData() {

  }

  @Test
  void saveChartDataTest() {

  }

}
