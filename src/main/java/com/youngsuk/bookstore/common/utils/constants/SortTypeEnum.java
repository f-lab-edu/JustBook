package com.youngsuk.bookstore.common.utils.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SortTypeEnum {
  Newest("00"), Likes("01");

  private final String code;

  public SortTypeEnum getNewest() {
    return Newest;
  }

  public SortTypeEnum getLikes() {
    return Likes;
  }
}
