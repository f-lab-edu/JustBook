package com.youngsuk.bookstore.common.utils.converter;

import com.youngsuk.bookstore.common.utils.constants.SortTypeEnum;
import org.springframework.core.convert.converter.Converter;
import static com.youngsuk.bookstore.common.utils.SortTypeUtils.findSortTypeEnum;

public class StringToSortTypeEnumConverter implements Converter<String, SortTypeEnum> {

  @Override
  public SortTypeEnum convert(String code) {
    return findSortTypeEnum(code);
  }

}
