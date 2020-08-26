package com.youngsuk.bookstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class LoginRequiredException extends ResponseStatusException {
    public LoginRequiredException() {
        super(HttpStatus.BAD_REQUEST, "Need login");
    }
}
