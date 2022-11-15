package com.project.helpesk.dto;

/**
 * @author opera_ao6omsd api class
 *
 */
public final class ApiResponse {

    /**
     * @param message message.
     * @param success success.
     */
    public ApiResponse(final String message, final boolean success) {
        super();
        this.message = message;
        this.success = success;
    }

    /**
     * constructor.
     */
    public ApiResponse() {

    }

    /**
     * String message.
     */
    private String message;
    /**
     * sucess.
     */
    private boolean success;

    /**
     * @return message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message set message
     */
    public void setMessage(final String message) {
        this.message = message;
    }

    /**
     * @return success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * @param success set sucess
     */
    public void setSuccess(final boolean success) {
        this.success = success;
    }

}
