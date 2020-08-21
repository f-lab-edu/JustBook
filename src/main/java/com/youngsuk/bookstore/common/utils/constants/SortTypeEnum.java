package com.youngsuk.bookstore.common.utils.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SortTypeEnum {
  Newest("00"), Likes("01");

  private final String code;
}
