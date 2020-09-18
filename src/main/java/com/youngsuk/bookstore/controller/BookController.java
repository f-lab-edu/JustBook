package com.youngsuk.bookstore.controller;

import com.youngsuk.bookstore.common.utils.constants.SortTypeEnum;
import com.youngsuk.bookstore.dto.BookCategoryDto;
import com.youngsuk.bookstore.dto.BookDto;
import com.youngsuk.bookstore.dto.PagingDto;
import com.youngsuk.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/books/categories/", produces = "application/json; charset=UTF-8")
public class BookController {

  @Autowired
  private BookService bookService;

  /**
   * @return 모든 책의 카테고리를 리턴한다 ex) 인문학, 철학 ..
   */
  @GetMapping
  public List<BookCategoryDto> getCategoryList() {
    return bookService.cacheBookCategoryList();
  }

  @GetMapping
  public List<BookDto> getBookByCategoryName() {
    //todo defalut 최신순
  }

  @GetMapping
  public List<BookDto> getBookBySortType() {
    //todo
  }



