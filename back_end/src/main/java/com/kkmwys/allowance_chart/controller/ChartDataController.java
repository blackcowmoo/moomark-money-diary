package com.kkmwys.allowance_chart.controller;

import com.kkmwys.allowance_chart.data.dto.CategoryDto;
import com.kkmwys.allowance_chart.data.dto.ChartDataDto;
import com.kkmwys.allowance_chart.data.form.request.RequestSaveDataForm;
import com.kkmwys.allowance_chart.exception.CategoryException;
import com.kkmwys.allowance_chart.exception.ChartDataException;
import com.kkmwys.allowance_chart.service.ChartDataService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChartDataController {

  private final ChartDataService chartDataService;

  /****** POST ******/
  @PostMapping("chart/data")
  public ResponseEntity<ChartDataDto> saveChartData(@RequestBody RequestSaveDataForm saveDataForm) {
    ChartDataDto resultDto = null;
    try {
      resultDto = chartDataService.saveChartData(saveDataForm);
    } catch (CategoryException e) {
      e.printStackTrace();
      ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(resultDto);
  }


  /****** GET ******/
  @GetMapping("chart/data/all")
  public ResponseEntity<List<ChartDataDto>> getChartDataList() {
    return ResponseEntity.ok(chartDataService.getAllChartData());
  }

  @GetMapping("/chart/data/{id}")
  public ResponseEntity<ChartDataDto> getChartDataById(@PathVariable Long id) {
    try {
      return ResponseEntity.ok(chartDataService.getChartDataById(id));
    } catch (ChartDataException e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
  }

  @GetMapping("/chart/data/category")
  public ResponseEntity<List<ChartDataDto>> getChartDataByCategory(CategoryDto categoryDto) {
    List<ChartDataDto> resultList = null;
    try {
      resultList = chartDataService.getChartDataListByCategory(categoryDto);
    } catch (CategoryException e) {
      e.printStackTrace();
      ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(resultList);
  }

  @GetMapping("/chart/data/category/type/income")
  public ResponseEntity<List<ChartDataDto>> getChartDataByCategoryIncomeType() {
    return ResponseEntity.ok(chartDataService.getChartDataListByCategoryType("income"));
  }

  @GetMapping("/chart/data/category/type/spending")
  public ResponseEntity<List<ChartDataDto>> getChartDataByCategorySpendingType() {
    return ResponseEntity.ok(chartDataService.getChartDataListByCategoryType("spending"));
  }

  @GetMapping("/chart/data/category/type/{name}")
  public ResponseEntity<List<ChartDataDto>> getChartDataByCategoryName(@PathVariable String name) {
    return ResponseEntity.ok(chartDataService.getChartDataListByCategoryName(name));
  }

  /****** PUT ******/

  @PutMapping("chart/data/{id}")
  public ResponseEntity<ChartDataDto> updateChartData(@PathVariable Long id,
      @RequestBody RequestSaveDataForm requestSaveDataForm) {
    try {
      return ResponseEntity.ok(chartDataService.updateChartData(id, requestSaveDataForm));
    } catch (ChartDataException | CategoryException e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
  }

  /****** DELETE ******/

  @DeleteMapping("chart/data")
  public void deleteChartData(@RequestBody Long id) {
    try {
      chartDataService.deleteChartData(id);
    } catch (ChartDataException e) {
      e.printStackTrace();
    }
  }
}
