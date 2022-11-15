package com.project.helpesk.dto;

/**
 * @author opera_ao6omsd.
 *
 */

public final class RoleDto {
    /**
     * int id.
     */
    private int id;
    /**
     * String name.
     */
    private String name;

    /**
     * role dto.
     */
    public RoleDto() {

    }

    /**
     * @param id   set id.
     * @param name set name.
     */
    public RoleDto(final int id, final String name) {
        super();
        this.id = id;
        this.name = name;
    }

    /**
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * @param id id.
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name name.
     */
    public void setName(final String name) {
        this.name = name;
    }

}
