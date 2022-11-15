package com.project.helpesk.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author opera_ao6omsd.
 *
 */
public final class UserRoleDto {

    /**
     * id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    /**
     * role id.
     */
    private int roleId;
    /**
     * userId.
     */
    private int userId;

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
     * UserRoleDto.
     */
    public UserRoleDto() {

    }

    /**
     * @param userId userId.
     * @param roleId roleID.
     */
    public UserRoleDto(final int userId, final int roleId) {
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

}
