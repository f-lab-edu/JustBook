package com.youngsuk.bookstore.dto;

import lombok.Getter;
import lombok.Setter;


/**
 * 사용자가 무한 스크롤 기능을 사용할 때, 새 페이지를 전달 하기 위해 만들어진 데이터 전송을 위한 클래스이다.
 * 해당 클래스에서 생성된 객체에 페이징을 위한 사용자의 데이터가 입력 되어야 하기 때문에 가변 객체가 된다.
 *
 * bookstore.resources.query.book 폴더의 bookQuery를 보면 패이징을 위해 해당 클래스의 객체가 쿼리문에 사용 되는것을 확인할 수 있다.
 */
@Getter
@Setter
public final class PagingDto  {
  private int onePageLimit;
  private int lastId;
  private int pagingCursor;
}
