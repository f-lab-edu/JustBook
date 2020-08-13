package com.youngsuk.bookstore.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youngsuk.bookstore.common.utils.constants.SortTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
public final class BookDto {
  @JsonIgnore
  private String bookId;
  private String bookName;
  private String bookAuthorName;
  private String bookCost;
  private String bookPublishDate;
  private String bookIntroduce;
  private String bookAuthorIntroduce;
  private String bookIndexDescription;
  private String bookLikeCount;

  @Setter
  private String bookCategory;

  @Setter
  @JsonIgnore
  private PagingDto pagingDto;

  @Setter
  @JsonIgnore
  private SortTypeEnum sortTypeEnum;
}
