package com.youngsuk.bookstore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class PagingDto {
  private int onePageLimit;
  private int lastId;
  private int pagingCursor;
}
