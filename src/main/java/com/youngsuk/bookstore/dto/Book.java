package com.youngsuk.bookstore.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Book {
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
