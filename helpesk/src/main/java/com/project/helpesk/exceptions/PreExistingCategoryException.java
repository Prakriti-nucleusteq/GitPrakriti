package com.project.helpesk.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author opera_ao6omsd pre Existing CategoryException.
 *
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PreExistingCategoryException extends Exception {

    /**
     * message print.
     */
    private static final long serialVersionUID = 613001676903725479L;

    /**
     * @param message message.
     */
    public PreExistingCategoryException(final String message) {
        super(message);
    }

}
