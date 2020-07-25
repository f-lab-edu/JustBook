package com.youngsuk.bookstore.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.youngsuk.bookstore.dto.Book;
import com.youngsuk.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/books/categorys/", produces = "application/json; charset=UTF-8")
public class BookController {

  @Autowired
  private BookService bookService;

  @GetMapping(value = "{categoryName}")
  public ResponseEntity<String> getBookByCategory(@PathVariable String categoryName,
                                                  @RequestParam int onePageLimit, String sortType, String pagingCursor, int lastId,
                                                  Book book) throws JsonProcessingException {
    String bookList = bookService.selectBookByCategory(book, categoryName, onePageLimit, sortType, pagingCursor, lastId);
    return ResponseEntity.status(HttpStatus.OK).body(bookList);
  }

}
