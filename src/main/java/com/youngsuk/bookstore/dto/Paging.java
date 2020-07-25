package com.youngsuk.bookstore.dto;


import com.youngsuk.bookstore.common.utils.constants.SortTypeConstants;
import lombok.Setter;

@Setter
public class Paging extends SortTypeConstants {
  String sortType;
  String pagingCursor;
  int onePageLimit;
  int lastId;
}
