package com.project.helpesk.handler;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.project.helpesk.customannotation.Generated;
import com.project.helpesk.entities.ErrorResponse;

import com.project.helpesk.exceptions.PreExistingCategoryException;
import com.project.helpesk.exceptions.PreExistingUserException;

/**
 * Custom class for global exception handling.
 *
 * @author prakriti.
 *
 */
@ControllerAdvice
@Generated
public final class CustomExceptionHandler {
    /**
     * Exception method if user already exists.
     *
     * @param ex      Exception.
     * @param request Webrequest.
     * @return Error and Http Status.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @ExceptionHandler(PreExistingUserException.class)
    public ResponseEntity<ErrorResponse> preExistingUserException(final PreExistingUserException ex,
            final WebRequest request) {
        List<String> details = new ArrayList<String>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("User Already exists", details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
    /**
     * Exception method if email+password combination is incorrect.
     *
     * @param ex      Exception.
     * @param request Webrequest.
     * @return Error and Http Status.
     */
    /*
     * @SuppressWarnings({ "unchecked", "rawtypes" })
     *
     * @ExceptionHandler(IncorrectCombinationException.class) public
     * ResponseEntity<ErrorResponse>
     * incorrectCombinationException(IncorrectCombinationException ex, WebRequest
     * request) { List<String> details = new ArrayList<String>();
     * details.add(ex.getLocalizedMessage()); ErrorResponse error = new
     * ErrorResponse("Incorrect email and password combination", details); return
     * new ResponseEntity(error, HttpStatus.BAD_REQUEST); }
     *//**
        * Exception method if no user records found.
        *
        * @param ex      Exception.
        * @param request Webrequest.
        * @return Error and Http Status.
        *//*
           * @ExceptionHandler(UsersNotFoundException.class) public
           * ResponseEntity<ErrorResponse> usersNotFoundException(UsersNotFoundException
           * ex, WebRequest request) { List<String> details = new ArrayList<String>();
           * details.add(ex.getLocalizedMessage()); ErrorResponse error = new
           * ErrorResponse("No users found", details); return new
           * ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND); }
           */

    /**
     * Exception method if category exists.
     *
     * @param ex      Exception.
     * @param request Webrequest.
     * @return Error and Http Status.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @ExceptionHandler(PreExistingCategoryException.class)
    public ResponseEntity<ErrorResponse> preExistingCategoryException(final PreExistingCategoryException ex,
            final WebRequest request) {
        List<String> details = new ArrayList<String>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Category  already exists", details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

}
