package com.example.neobookChallenge.exceptions;

import com.example.neobookChallenge.responses.ExceptionResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ExceptionResponse handleBadRequestException(com.example.neobookChallenge.exceptions.BadRequestException e) {

        return new ExceptionResponse(
                e.getClass().getSimpleName(),
                e.getMessage()
        );
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ExceptionResponse handlerNotFoundException(NotFoundException e) {
        return new ExceptionResponse(
                e.getClass().getSimpleName(),
                e.getMessage()
        );
    }
}
