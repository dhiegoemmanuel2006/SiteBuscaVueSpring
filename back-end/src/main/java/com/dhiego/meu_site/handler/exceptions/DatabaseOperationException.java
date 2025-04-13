package com.dhiego.meu_site.handler.exceptions;

import com.dhiego.meu_site.handler.ApiException;
import org.springframework.http.HttpStatus;

public class DatabaseOperationException extends ApiException {
    public DatabaseOperationException(String operation, String cause) {
        super(String.format("Falha ao %s: %s", operation, cause),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}