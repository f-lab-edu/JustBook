package com.youngsuk.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @Autowired
    private ApiDao apiDao;

    @GetMapping(path = "/helloWorld")
    public String helloWorld() {
        return apiDao.selectName();
    }

}
