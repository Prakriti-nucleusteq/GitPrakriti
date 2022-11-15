package com.project.helpesk.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception Class to check if user already exists.
 * @author Shantanu
 *
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PreExistingUserException extends Exception {

    /**
     * SerialId for constructor.
     */
    private static final long serialVersionUID = 6727835538644008710L;
    /**
     * Constructor for custom exception.
     * @param message Response message.
     */
    public PreExistingUserException(final String message) {
        super(message);
    }
}
