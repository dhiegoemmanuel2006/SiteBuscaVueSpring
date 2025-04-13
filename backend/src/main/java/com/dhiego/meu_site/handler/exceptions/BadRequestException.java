package com.dhiego.meu_site.handler.exceptions;

import com.dhiego.meu_site.handler.ApiException;
import org.springframework.http.HttpStatus;

public class BadRequestException extends ApiException {
    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
