package com.youngsuk.bookstore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book extends Paging {
  String id;
  String bookName;
  String bookWriter;
  String bookCategoryName;
  String bookCost;
  String bookPublishDate;
  String bookIntroduce;
  String bookAuthorIntroduce;
  String bookIndexDescription;
  String bookBuyNumber;
  String bookLikeNumber;
}
