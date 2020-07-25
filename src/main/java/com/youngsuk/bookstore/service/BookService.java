package com.youngsuk.bookstore.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youngsuk.bookstore.dto.Book;
import com.youngsuk.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

import static com.youngsuk.bookstore.common.utils.BookListToJsonUtils.putBookListInJsonKeyString;

@Service
public class BookService {

  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private ObjectMapper objectMapper;

  // [@Cacheable 동작 방식]
  // 1. key값을 Redis에서 확인한다. (redis-cli monitor를 통해서 확인)
  // 2. key값이 없으면 해당 메소드를 실행한다.
  // (만약 key값이 있다면 메소드를 실행하지 않고 캐시 저장소에서 해당 key값의 value값을 가져온다.)
  // 3. return 값을 key값에 대응하는 value에 저장한다.
  @Cacheable(cacheNames = "selectBooksByCategoryCache",
      key = "{#categoryName, #sortType, #pagingCursor}")
  public String selectBookByCategory(Book book,
                                     String categoryName,
                                     int onePageLimit,
                                     String sortType,
                                     String pagingCursor,
                                     int lastId) throws JsonProcessingException {

    book.setBookCategoryName(categoryName);
    book.setSortType(sortType);
    book.setPagingCursor(pagingCursor);
    book.setLastId(lastId);
    book.setOnePageLimit(onePageLimit);

    List<Book> bookList;
    String bookListKeyName = "bookList";

    bookList = bookRepository.selectBookByCategory(book);


    // 레디스에 자바 object 데이터를 전송하기 위해서는 직렬화가 필요하다.
    // 그런데 직렬화의 반대의 과정인 역직렬화에는 보안적인 문제가 존재한다.
    // 이유는 역직렬화 과정에 해커가 악의적인 데이터를 집어넣을 수 있기 떄문이다.
    // 이 문제는 자바 직렬화, jackson 등의 여러 직렬화 기술들에서 발견되고 있다.
    // 지금 까지 찾아본 대안으로는 커스텀한 직렬화 방법을 만드는 것이다.
    // 이 방법을 사용하면 해커가 데이터의 구조를 파악하기 어렵기 때문에 역직렬화 과정에서 악의적인 데이터를 주입하기가 어려워진다.
    // 캐싱된 json 데이터를 POJO에 넣어줄때도 역직렬화가 필요하다.
    return putBookListInJsonKeyString(bookList, objectMapper);
  }



}
