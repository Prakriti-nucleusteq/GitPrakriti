package com.timesheet.timesheet.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * @author opera_ao6omsd RescourseNotFound.
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RescourseNotFound extends Exception{

    

        /**
         * serialVersionUID.
         */
        private static final long serialVersionUID = 3183679764162247369L;
         
        /**
         * @param message RescourseNotFound.
         */
        public RescourseNotFound( String message) {
            super(message);
    }

}
