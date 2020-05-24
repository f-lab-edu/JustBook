package com.youngsuk.bookstore.repository;

import com.youngsuk.bookstore.dto.Book;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {
    private final static String NAMESPACE = "com.youngsuk.bookstore.repository.BookRepository.";

    @Autowired
    private SqlSession sqlSession;

    public List<Book> selectBookCategory(Book book){
        return sqlSession.selectList(NAMESPACE + "selectBookCategoryData", book);
    }

    public Book selectSingleBook(Book book){
        return sqlSession.selectOne(NAMESPACE + "selectSingleBookData", book.getId());
    }
}
