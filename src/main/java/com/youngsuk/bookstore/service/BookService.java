package com.youngsuk.bookstore.service;

import com.youngsuk.bookstore.dto.Book;
import com.youngsuk.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> selectBookByCategory(Book book, String categoryName) {
        book.setBookCategoryName(categoryName);
        List<Book> bookList = bookRepository.selectBookByCategory(categoryName);

        return bookList;
    }
}
