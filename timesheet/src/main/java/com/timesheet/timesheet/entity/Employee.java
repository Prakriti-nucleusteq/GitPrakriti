package com.timesheet.timesheet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author opera_ao6omsd employe.
 *
 */
@Entity
@Table
public class Employee {

    /**
     * name.
     */
    @Id
    @Column
    private String name;
    
    /**
     * email.
     */
    @Column
    private String email;
    
    
    /**
     * to string.
     */
    @Override
    public String toString() {
        return ""+name + ","+email + "";
    }
    /**
     * @return name.
     */
    public String getName() {
        return name;
    }
    /**
     * @param name setname.
     */
    public void setName(final String name) {
        this.name = name;
    }
    /**
     * @return email.
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email set email.
     */
    public void setEmail(final String email) {
        this.email = email;
    }
    /**
     * @param name name.
     * @param email email.
     */
    public Employee(final String name, final String email) {
        super();
        this.name = name;
        this.email = email;
    }
    /**
     * employee.
     */
    public Employee() {
        // TODO Auto-generated constructor stub
    }
}
