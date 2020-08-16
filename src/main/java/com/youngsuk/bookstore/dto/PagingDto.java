package com.youngsuk.bookstore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/*
 * 해당 class는 @Setter 때문에 불변 객체가 아니다.
 * @Setter는 setter함수를 public으로 만들기 때문에 setter가 적용된 인스턴스 변수를 다른 사용자가 변경할 수 있게 한다.
 */
public final class PagingDto  {
  private int onePageLimit;
  private int lastId;
  private int pagingCursor;
}
