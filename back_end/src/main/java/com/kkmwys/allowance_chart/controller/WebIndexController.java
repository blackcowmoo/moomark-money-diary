package com.kkmwys.allowance_chart.controller;

import com.kkmwys.allowance_chart.data.dto.CategoryDto;
import com.kkmwys.allowance_chart.domain.Category;
import com.kkmwys.allowance_chart.service.CategoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WebIndexController {

  private CategoryService categoryService;

  @GetMapping("/")
  public String getRootPage() {
    return "/index";
  }

  @GetMapping("/index")
  public String getIndexPage() {
    return "/index";
  }

  @GetMapping("/income")
  public String getIncomePage() {
    return "/income";
  }

  @GetMapping("/edit")
  public String getEditPage() {
    return "/edit";
  }

  @GetMapping("/config")
  public String getSettingPage(Model model) {
    List<CategoryDto> incomeCategoryList =  categoryService.getCategoryListByType("income");
    List<CategoryDto> spendingCategoryList = categoryService.getCategoryListByType("spending");

    model.addAttribute("incomeCategoryList", incomeCategoryList);
    model.addAttribute("spendingCategoryList", spendingCategoryList);
    return "/config";
  }

}
