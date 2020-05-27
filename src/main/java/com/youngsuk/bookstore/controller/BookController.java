package com.youngsuk.bookstore.controller;

import com.youngsuk.bookstore.dto.Book;
import com.youngsuk.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books/category/{categoryName}")
    public ResponseEntity<List<Book>> getBookByCategory(@PathVariable String categoryName, Book book) {
        List<Book> bookList = bookService.selectBookByCategory(book, categoryName);

        return ResponseEntity.status(HttpStatus.OK).body(bookList);
    }

}
