package br.com.easypark.backend.handler;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.easypark.backend.exception.ResourceNotFoundException;
import br.com.easypark.backend.exception.ResourceNotFoundExceptionDetail;

@RestControllerAdvice
public class RestHandlerexceptionBuilder {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        ResourceNotFoundExceptionDetail resourceNotFoundDetail = new ResourceNotFoundExceptionDetail.Builder()
                .title("Resource not found!")
                .detail(resourceNotFoundException.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .developerMessage(resourceNotFoundException.getClass().getName()).build();

        return new ResponseEntity<>(resourceNotFoundDetail, HttpStatus.NOT_FOUND);
    }
   
}
