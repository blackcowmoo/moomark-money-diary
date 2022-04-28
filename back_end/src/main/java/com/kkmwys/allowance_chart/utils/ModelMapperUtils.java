package com.kkmwys.allowance_chart.utils;

import org.modelmapper.ModelMapper;

public class ModelMapperUtils {

  private static final ModelMapper MODEL_MAPPER = new ModelMapper();

  private ModelMapperUtils() throws IllegalAccessException {
    throw new IllegalAccessException("This class is util class");
  }

  public static ModelMapper getModelMapper() {
    return MODEL_MAPPER;
  }
}
