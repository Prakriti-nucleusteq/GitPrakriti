package com.project.helpesk.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author opera_ao6omsd.
 *
 */
@Entity
public final class UserRole {

    /**
     * id.
     */
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;


    /**
     * userid.
     */
    private int userId;

    /**
     * roleId.
     */
    private int roleId;





    /**
     * UserRole.
     */
    public UserRole() {

    }

    /**
     * @param userId userId.
     * @param roleId roleId.
     */
    public UserRole(final int userId, final int roleId) {
        super();
        this.userId = userId;
        this.roleId = roleId;
    }

    /**
     * @return userId.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId userId.
     */
    public void setUserId(final int userId) {
        this.userId = userId;
    }

    /**
     * @return roleId.
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * @param roleId roleId.
     */
    public void setRoleId(final int roleId) {
        this.roleId = roleId;
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


}
