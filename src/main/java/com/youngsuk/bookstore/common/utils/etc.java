package com.youngsuk.bookstore.common.utils;

import java.util.HashMap;
import java.util.Map;

public class etc {

    private etc() {}

    //2개의 파라미터를 넘기고 싶었지만 방법이 Map을 사용해서 하는 방법과, POJO를 사용해서 넘기는 방법이 있었다.
    //POJO를 사용하면 하나의 메소드에 있는 파라미터 뿐만 아니라 또 다른 메소드의 파라미터까지 바꿔야 하는 문제가 있어서 Map을 사용했다.
    public static Map makeParamToHashmap(String categoryName, int offsetForPaging) {
        Map map = new HashMap();
        map.put("bookCategoryName", categoryName);
        map.put("offset", offsetForPaging);

        return map;
    }
}
