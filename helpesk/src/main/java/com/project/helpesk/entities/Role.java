package com.project.helpesk.entities;

import javax.persistence.Entity;

import javax.persistence.Id;

/**
 * @author opera_ao6omsd
 *
 */
@Entity

public final class Role {

    /**
     * int id.
     */
    @Id
    private int id;
    /**
     * name.
     */
    private String name;

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

    /**
     * @param id   id.
     * @param name name.
     */
    public Role(final int id, final String name) {
        super();
        this.id = id;
        this.name = name;
    }

    /**
     * role.
     */
    public Role() {
        super();
        // TODO Auto-generated constructor stub
    }

}
