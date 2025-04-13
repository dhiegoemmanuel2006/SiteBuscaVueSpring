package com.dhiego.meu_site.handler.exceptions;

import com.dhiego.meu_site.handler.ApiException;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiException {
    public ResourceNotFoundException(String resourceName, String identifier) {
        super(String.format("%s não encontrado com o identificador: %s", resourceName, identifier),
                HttpStatus.NOT_FOUND);
    }
}