package com.youngsuk.bookstore.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youngsuk.bookstore.dto.Book;
import com.youngsuk.bookstore.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    private String makeBookListToJson(List<Book> bookList) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(bookList);
    }

    @Cacheable(cacheNames = "selectBooksByCategoryCache", key = "#categoryName")
    public String selectBookByCategory(Book book, String categoryName) throws JsonProcessingException {
        book.setBookCategoryName(categoryName);
        List<Book> bookList = bookRepository.selectBookByCategory(categoryName);
        return makeBookListToJson(bookList);
    }


}
