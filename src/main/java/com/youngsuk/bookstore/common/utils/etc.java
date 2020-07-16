package com.youngsuk.bookstore.common.utils;

import java.util.HashMap;
import java.util.Map;

public class etc {

  private etc() {}

  public static Map<String, Object> makeParamToHashmap(String categoryName, int offsetForPaging) {
    Map<String, Object> map = new HashMap<>();
    map.put("bookCategoryName", categoryName);
    map.put("offset", offsetForPaging);



    return map;
  }
}
