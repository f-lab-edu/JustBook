package com.youngsuk.bookstore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    String id;
    String bookName;
    String bookWriter;
    String bookCost;
    String bookPublishDate;
    String bookIntroduce;
    String bookAuthorIntroduce;
    String bookIndexDescription;
    String bookCategoryName;
    String bookBuyNumber;
    String bookLikeNumber;
}
