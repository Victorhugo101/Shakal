package br.com.easypark.backend.handler;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.easypark.backend.exception.ResourceNotFoundException;
import br.com.easypark.backend.exception.ResourceNotFoundExceptionDetail;

@RestControllerAdvice
public class RestHandlerexceptionBuilder extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        ResourceNotFoundExceptionDetail resourceNotFoundDetail = new ResourceNotFoundExceptionDetail.Builder()
                .title("Resource not found!")
                .detail(resourceNotFoundException.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .developerMessage(resourceNotFoundException.getClass().getName()).build();

        return new ResponseEntity<>(resourceNotFoundDetail, HttpStatus.NOT_FOUND);
    }
   
    @ExceptionHandler({AccessDeniedException.class })
    public ResponseEntity<?> handleAccessDeniedException(
      Exception ex, WebRequest request) {
    	 ResourceNotFoundExceptionDetail resourceNotFoundDetail = new ResourceNotFoundExceptionDetail.Builder()
                 .title("You don't have permission")
                 .detail(ex.getMessage())
                 .status(HttpStatus.UNAUTHORIZED.value())
                 .developerMessage(ex.getClass().getName()).build();
        return new ResponseEntity<Object>(resourceNotFoundDetail, HttpStatus.UNAUTHORIZED);
    }
}
