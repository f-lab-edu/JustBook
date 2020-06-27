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


@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books/category/{categoryName}")
    public ResponseEntity<String> getBookByCategory(@PathVariable String categoryName, Book book) throws JsonProcessingException {
        String bookList = bookService.selectBookByCategory(book, categoryName);
        return ResponseEntity.status(HttpStatus.OK).body(bookList);
    }

}
