package com.youngsuk.bookstore.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.youngsuk.bookstore.common.utils.constants.SortTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
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

  @JsonIgnore
  private PagingDTO pagingDTO;
  @JsonIgnore
  private SortTypeEnum sortTypeEnum;
}
