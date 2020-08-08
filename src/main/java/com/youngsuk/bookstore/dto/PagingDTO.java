package com.youngsuk.bookstore.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PagingDTO {
  private int onePageLimit;
  private int lastId;
  private int pagingCursor;
}
