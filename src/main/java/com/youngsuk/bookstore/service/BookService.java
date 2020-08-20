package com.youngsuk.bookstore.service;

import com.youngsuk.bookstore.common.utils.constants.SortTypeEnum;
import com.youngsuk.bookstore.dto.BookDto;
import com.youngsuk.bookstore.dto.PagingDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
  public List<BookDto> getBookByCategory(BookDto bookDto, PagingDto pagingDto,
                                         SortTypeEnum sortTypeEnum,
                                         String categoryName);
}
