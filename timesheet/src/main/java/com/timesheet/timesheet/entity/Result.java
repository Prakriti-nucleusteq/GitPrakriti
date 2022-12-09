package com.timesheet.timesheet.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author opera_ao6omsd result.
 *
 */
@Entity
public class Result {

    /**
     * name.
     */
    @Id
    private String name;
    /**
     * disturbance.
     */
    private int disturbance;
    
    
    /**
     * @return name.
     */
    public String getName() {
        return name;
    }
    /**
     * @param name set name.
     */
    public void setName(final String name) {
        this.name = name;
    }
    /**
     * @return disturbance.
     */
    public int getDisturbance() {
        return disturbance;
    }
    /**
     * @param disturbance disturbance.
     */
    public void setDisturbance(final int disturbance) {
        this.disturbance = disturbance;
    }
    /**
     * to string.
     */
    @Override
    public String toString() {
        return "Result [name=" + name + ", disturbance=" + disturbance + "]";
    }
    /**
     * @param name name.
     * @param disturbance disturbance.
     */
    public Result(final String name, final int disturbance) {
        super();
        this.name = name;
        this.disturbance = disturbance;
    }
    /**
     * result.
     */
    public Result() {
        // TODO Auto-generated constructor stub
    }
    
    
    
}
