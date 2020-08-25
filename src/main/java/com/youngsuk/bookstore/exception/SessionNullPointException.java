package com.youngsuk.bookstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SessionNullPointException extends ResponseStatusException {
    public SessionNullPointException() {
        super(HttpStatus.BAD_REQUEST, "User Session Null Exception");
    }
}
