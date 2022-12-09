package com.timesheet.timesheet.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author opera_ao6omsd filenot found excepton.
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FileNotFoundException extends Exception{

        /**
         * long.
         */
        private static final long serialVersionUID = 3183679764162247369L;
         
        /**
         * @param message message.
         */
        public FileNotFoundException(final String message) {
            super(message);
    }
}




