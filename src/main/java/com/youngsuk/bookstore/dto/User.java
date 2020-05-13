package com.youngsuk.bookstore.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

@Getter
@Setter
@Repository
public class User {
    private String userId;
    private String userPassword;
    private String userName;
    private String userEmail;
}
