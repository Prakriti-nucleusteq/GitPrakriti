package com.project.helpesk.exceptions;
/**
 * @author validation exception class.
 *
 */
public final class ValidationException extends RuntimeException {
    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = -2762794181125437706L;
//    /**
//     * validation Exception 1.
//     */
//    public ValidationException() {
//    }
    /**
     * @param message Exception 2.
     */
    public ValidationException(final String message) {
        super(message);
    }
//    /**
//     * @param message Exception3.
//     * @param cause   cause
//     */
//    public ValidationException(final String message, final Throwable cause) {
//        super(message, cause);
//    }
//    /**
//     * @param cause Exception4.
//     */
//    public ValidationException(final Throwable cause) {
//        super(cause);
//    }
//    /**
//     * @param message            message
//     * @param cause              cause
//     * @param enableSuppression  enableSuppression
//     * @param writableStackTrace writableStackTrace
//     */
//    public ValidationException(final String message, final Throwable cause, final boolean enableSuppression,
//            final boolean writableStackTrace) {
//        super(message, cause, enableSuppression, writableStackTrace);
//    }
}
