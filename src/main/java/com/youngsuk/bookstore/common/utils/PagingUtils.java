package com.youngsuk.bookstore.common.utils;

public class PagingUtils {

    private PagingUtils() {}


    public static int makeOffsetForPaging(int currentPageNumber) {
        int onePageContentAmount = 10;
        //offset을 만드는 알고리즘 입니다.
        //현재 페이지에서 1을 빼고 하나의 페이지에 들어갈 아이템의 갯수를 곱해서 다음 페이지의 시작점을 알 수 있습니다.
        return (currentPageNumber -1) * onePageContentAmount;
    }
}
