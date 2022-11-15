package com.project.helpesk.exceptions;

/**
 * @author opera_ao6omsd
 *
 */
public final class ResourceNotFoundException extends RuntimeException {

    /**
     *serial version id.
     */
    private static final long serialVersionUID = -1331647904639430259L;
    /**
     * resourceName.
     */
    private String resourceName;
    /**
     * fieldname.
     */
    private String fieldName;
    /**
     * field value.
     */
    private long fieldValue;

    /**
     * @return resource name
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * @param resourceName set resource name
     */
    public void setResourceName(final String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * @return field name.
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * @param fieldName set field name.
     */
    public void setFieldName(final String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * @return fiels name.
     */
    public long getFieldValue() {
        return fieldValue;
    }

    /**
     * @param fieldValue set fiels value.
     */
    public void setFieldValue(final long fieldValue) {
        this.fieldValue = fieldValue;
    }

    /**
     * @param resourceName resource name.
     * @param fieldName    fieldname.
     * @param fieldValue   field value.
     */
    public ResourceNotFoundException(final String resourceName, final String fieldName, final long fieldValue) {
        super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
