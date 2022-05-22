package com.kkmwys.allowance_chart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebIndexController {

  @GetMapping("/")
  public String getRootPage() {
    return "/index";
  }

  @GetMapping("/index")
  public String getIndexPage() {
    return "/index";
  }


}
