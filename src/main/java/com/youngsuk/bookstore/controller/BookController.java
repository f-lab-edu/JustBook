package com.youngsuk.bookstore.controller;

import com.youngsuk.bookstore.common.utils.constants.SortTypeEnum;
import com.youngsuk.bookstore.dto.BookDto;
import com.youngsuk.bookstore.dto.PagingDto;
import com.youngsuk.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/books/categories/", produces = "application/json; charset=UTF-8")
public class BookController {

  @Autowired
  private BookService bookService;

  @GetMapping(value = "{categoryName}")
  public ResponseEntity<List<BookDto>> giveBookByCategory(BookDto bookDto,
                                                          @PathVariable String categoryName,
                                                          @RequestParam SortTypeEnum sortType,
                                                          PagingDto pagingDto) {

    List<BookDto> bookList = bookService
        .getBookByCategory(bookDto, categoryName, sortType, pagingDto);

    return ResponseEntity.status(HttpStatus.OK).body(bookList);
  }

}
