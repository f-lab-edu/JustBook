package com.youngsuk.bookstore.common.utils;

import com.youngsuk.bookstore.common.utils.constants.SortTypeEnum;

import java.util.HashMap;
import java.util.Map;

public final class SortTypeUtils {

  private SortTypeUtils(){}

  public static final Map<String, SortTypeEnum> sortTypeMap = new HashMap<>();

  static {
    for (SortTypeEnum sortType : SortTypeEnum.values()) {
      sortTypeMap.put(sortType.getCode(), sortType);
    }
  }

  public static SortTypeEnum findSortTypeEnum(String code) {
    return sortTypeMap.get(code);
  }

}
