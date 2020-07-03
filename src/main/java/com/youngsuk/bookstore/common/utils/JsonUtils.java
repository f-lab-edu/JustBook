package com.youngsuk.bookstore.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youngsuk.bookstore.dto.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//책을 조회 하는 작업은 json 값의 변동 사항이 거의 없을것이라고 생각했기 때문에 따로 JACKSON 설정 파일을 만들지 않았다.
public class JsonUtils {

    private JsonUtils() {}

    public static String makeBookListToJson(List<Book> bookList) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, List<Book>> bookListHashMap = makeBookListToHashMap(bookList);

        return objectMapper.writeValueAsString(bookListHashMap);
    }

    //책들을 json 형태로 클라이언트에게 전달하는 api를 만들때 가독성을 높이기 위해 추가한 메소드 입니다.
    //이 메소드를 통해서 bookList라는 스트링값 안에 리스트 형태의 책들이 json에 들어가게 됩니다.
    // 해당 메소드가 없게 되면 리스트 형태의 데이터들이 어떤 값인지 직관적으로 알기 어려운 문제가 생기게 됩니다.
    private static Map<String, List<Book>> makeBookListToHashMap(List<Book> bookList) {
        Map<String, List<Book>> bookListHashMap = new HashMap<>();
        bookListHashMap.put("bookList",bookList);

        return bookListHashMap;
    }

}
