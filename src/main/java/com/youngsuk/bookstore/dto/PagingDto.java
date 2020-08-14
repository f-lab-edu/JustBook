package com.youngsuk.bookstore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/*
 * 해당 class는 @setter 때문에 불변 객체가 아니다.
 */
public final class PagingDto  {
  private int onePageLimit;
  private int lastId;
  private int pagingCursor;
}
