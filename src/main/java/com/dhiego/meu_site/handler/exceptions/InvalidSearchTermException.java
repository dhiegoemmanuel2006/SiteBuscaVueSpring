package com.dhiego.meu_site.handler.exceptions;

import org.apache.coyote.BadRequestException;

public class InvalidSearchTermException extends BadRequestException {
    public InvalidSearchTermException(String term) {
        super(String.format("Termo de busca inválido: '%s' - deve ter pelo menos 3 caracteres", term));
    }
}