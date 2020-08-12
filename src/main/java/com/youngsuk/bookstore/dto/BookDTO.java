package com.youngsuk.bookstore.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youngsuk.bookstore.common.utils.constants.SortTypeEnum;
import lombok.Getter;

@Getter
public class BookDTO {
  @JsonIgnore
  private String bookId;
  private String bookName;
  private String bookAuthorName;
  private String bookCategory;
  private String bookCost;
  private String bookPublishDate;
  private String bookIntroduce;
  private String bookAuthorIntroduce;
  private String bookIndexDescription;
  private String bookLikeCount;

  public void setBookCategory(String bookCategory) {
    this.bookCategory = bookCategory;
  }

  public void setPagingDTO(PagingDTO pagingDTO) {
    this.pagingDTO = pagingDTO;
  }

  public void setSortTypeEnum(SortTypeEnum sortTypeEnum) {
    this.sortTypeEnum = sortTypeEnum;
  }

  @JsonIgnore
  private PagingDTO pagingDTO;
  @JsonIgnore
  private SortTypeEnum sortTypeEnum;
}
