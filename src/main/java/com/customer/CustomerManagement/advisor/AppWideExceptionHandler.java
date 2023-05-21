package com.customer.CustomerManagement.advisor;

import com.customer.CustomerManagement.exception.NotFoundException;
import com.customer.CustomerManagement.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler
{
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException e)
    {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404,"Items Not Found ",e.getMessage()+"Sandaruwan"), HttpStatus.NOT_FOUND
        );
    }
}
