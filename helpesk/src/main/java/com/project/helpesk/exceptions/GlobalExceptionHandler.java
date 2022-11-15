package com.project.helpesk.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.helpesk.customannotation.Generated;
import com.project.helpesk.dto.ApiResponse;

/**
 * @author opera_ao6omsd global.
 *
 */
@RestControllerAdvice
@Generated
public final class GlobalExceptionHandler {

    /**
     * @param ex ex.
     * @return api response.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(final ResourceNotFoundException ex) {
        String message = ex.getMessage();
        ApiResponse apiResponse = new ApiResponse(message, false);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * @param ex ex.
     * @return response.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(
            final MethodArgumentNotValidException ex) {
        Map<String, String> resp = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            resp.put(fieldName, message);
        });

        return new // ResponseEntity.status(400).body(response);
        ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);

    }

    /**
     * @param ex validation exception.
     * @return ResponseEntity.
     */
    @ExceptionHandler(value = ValidationException.class)
    protected ResponseEntity<Object> handleConflict(final ValidationException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message", ex.getMessage());
        return ResponseEntity.status(400).body(response);
    }
}
