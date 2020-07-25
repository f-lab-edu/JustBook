package com.youngsuk.bookstore.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youngsuk.bookstore.dto.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BookListToJsonUtils {

  private BookListToJsonUtils() {}

  private static final Map<String, List<Book>> useOfPutListInJsonKeyStringHashMap = new HashMap<>();

  public static String putBookListInJsonKeyString(List<Book> bookList, ObjectMapper objectMapper)
      throws JsonProcessingException {
    String keyString = "bookList";

    useOfPutListInJsonKeyStringHashMap.put(keyString, bookList);

    return objectMapper.writeValueAsString(useOfPutListInJsonKeyStringHashMap);
  }
}
