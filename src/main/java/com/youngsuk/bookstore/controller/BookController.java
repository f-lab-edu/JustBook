package com.youngsuk.bookstore.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.youngsuk.bookstore.common.utils.constants.SortTypeEnum;
import com.youngsuk.bookstore.dto.BookDTO;
import com.youngsuk.bookstore.dto.PagingDTO;
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
@RequestMapping(value = "/books/categories/", produces = "application/json; charset=UTF-8")
public class BookController {

  @Autowired
  private BookService bookService;

  @GetMapping(value = "{categoryName}")
  public ResponseEntity<String> giveBookByCategory(BookDTO bookDTO,
                                                  @PathVariable String categoryName,
                                                  @RequestParam SortTypeEnum sortType, PagingDTO pagingDTO) throws JsonProcessingException {

    String bookJson = bookService.getBookByCategory(bookDTO, categoryName, sortType, pagingDTO);
    return ResponseEntity.status(HttpStatus.OK).body(bookJson);
  }

}
