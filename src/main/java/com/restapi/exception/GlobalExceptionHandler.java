package com.restapi.exception;

import com.restapi.exception.common.AppException;
import com.restapi.exception.common.InvalidUserException;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.response.common.APIResponse;
import com.restapi.response.common.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.security.sasl.AuthenticationException;
import java.util.ArrayList;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private APIResponse response;

    // handle specific exceptions
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse> handleResourceNotFoundException(
            ResourceNotFoundException exception, WebRequest webRequest) {
        return responseBuilder(HttpStatus.NOT_FOUND, exception.getMessage(), webRequest);
    }

    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<APIResponse> handleInvalidUserException(
            InvalidUserException exception, WebRequest webRequest) {
        return responseBuilder(HttpStatus.NOT_FOUND, exception.getMessage(), webRequest);
    }

    // handle auth exception
    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<APIResponse> handleAuthenticationException(Exception ex) {
        return responseBuilder(HttpStatus.UNAUTHORIZED, ex.getMessage(), null);
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<APIResponse> handleAppException(AppException exception,
                                                          WebRequest webRequest) {
        return responseBuilder(HttpStatus.BAD_REQUEST, exception.getMessage(), webRequest);
    }

    // global exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse> handleGlobalException(Exception exception,
                                                             WebRequest webRequest) {
        return responseBuilder(HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(), webRequest);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest webRequest) {

        ArrayList<String> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors()
                .forEach(error -> errors.add(error.getDefaultMessage()));

        String description = webRequest.getDescription(false);
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setError(new ErrorResponse(String.join(",", errors), description));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<APIResponse> responseBuilder(HttpStatus status,
                                                        String exception,
                                                        WebRequest webRequest) {
        String description = null;
        if (webRequest != null) {
            description = webRequest.getDescription(false);
        }
        response.setStatus(status.value());
        response.setError(new ErrorResponse(exception, description));

        return new ResponseEntity<>(response, status);
    }

}
