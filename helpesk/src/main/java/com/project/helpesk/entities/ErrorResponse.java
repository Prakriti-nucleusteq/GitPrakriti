package com.project.helpesk.entities;

import java.util.List;
import java.util.Objects;

/**
 * @author opera_ao6omsd
 *
 */
public final class ErrorResponse {
    /**
     * string message.
     */
    private String message;
    /**
     * List of string.
     */
    private List<String> details;

    /**
     * @return message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message set mesage.
     */
    public void setMessage(final String message) {
        this.message = message;
    }

    /**
     * @return detils.
     */
    public List<String> getDetails() {
        return details;
    }

    /**
     * @param details set details.
     */
    public void setDetails(final List<String> details) {
        this.details = details;
    }

    /**
     * hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(details, message);
    }

    /**
     * boolean equals.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ErrorResponse other = (ErrorResponse) obj;
        return Objects.equals(details, other.details) && Objects.equals(message, other.message);
    }

    /**
     * to string.
     */
    @Override
    public String toString() {
        return "ErrorResponse [message=" + message + ", details=" + details + "]";
    }

    /**
     * @param message message.
     * @param details details.
     */
    public ErrorResponse(final String message, final List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }

    /**
     * ErrorResponse.
     */
    public ErrorResponse() {
    }

}
