package com.project.helpesk.dto;

import java.util.Objects;

/**
 * @author opera_ao6omsd
 *
 */

public final class AddCategoryResponseDto {
    /**
     * obj id.
     */
    private Integer objId;
    /**
     * success.
     */
    private Boolean success;
    /**
     * message.
     */
    private String message;

    /**
     * @return objid.
     */
    public Integer getObjId() {
        return objId;
    }

    /**
     * @param objId objid.
     */
    public void setObjId(final Integer objId) {
        this.objId = objId;
    }

    /**
     * @return success.
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     * @param success success.
     */
    public void setSuccess(final Boolean success) {
        this.success = success;
    }

    /**
     * @return message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message message.
     */
    public void setMessage(final String message) {
        this.message = message;
    }

    /**
     * hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(message, objId, success);
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
        AddCategoryResponseDto other = (AddCategoryResponseDto) obj;
        return Objects.equals(message, other.message) && Objects.equals(objId, other.objId)
                && Objects.equals(success, other.success);
    }

    /**
     * to String.
     */
    @Override
    public String toString() {
        return "AddCategoryResponseDto [objId=" + objId + ", success=" + success + ", message=" + message + "]";
    }

    /**
     * @param objId   objid.
     * @param success success.
     * @param message message.
     */
    public AddCategoryResponseDto(final Integer objId, final Boolean success, final String message) {
        super();
        this.objId = objId;
        this.success = success;
        this.message = message;
    }

    /**
     * AddCategory.
     */
    public AddCategoryResponseDto() {

    }
}
