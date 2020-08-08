package com.youngsuk.bookstore.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youngsuk.bookstore.common.utils.constants.SortTypeEnum;
import com.youngsuk.bookstore.dto.BookDTO;
import com.youngsuk.bookstore.dto.PagingDTO;
import com.youngsuk.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private ObjectMapper objectMapper;

   /*
   [@Cacheable 동작 방식]
   1. key값을 Redis에서 확인한다. (redis-cli monitor를 통해서 확인)
   2. key값이 없으면 해당 메소드를 실행한다.
   (만약 key값이 있다면 메소드를 실행하지 않고 캐시 저장소에서 해당 key값의 value값을 가져온다.)
   3. return 값을 key값에 대응하는 value에 저장한다.
    */

  @Cacheable(cacheNames = "BookByCategoryCache",
      key = "{#categoryName}") //TODO. key값 추가하기
  public String getBookByCategory(BookDTO bookDTO, String categoryName,
                                         SortTypeEnum sortTypeEnum, PagingDTO pagingDTO) throws JsonProcessingException {
    bookDTO.setBookCategory(categoryName);
    bookDTO.setPagingDTO(pagingDTO);
    bookDTO.setSortTypeEnum(sortTypeEnum);
    List<BookDTO> bookList = bookRepository.selectBookByCategory(bookDTO);

    return objectMapper.writeValueAsString(bookList);
  }
}
