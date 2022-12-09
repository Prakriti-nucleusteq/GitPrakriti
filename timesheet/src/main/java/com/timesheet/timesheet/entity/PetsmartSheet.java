package com.timesheet.timesheet.entity;

import java.time.LocalDateTime;


import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author opera_ao6omsd.
 *
 */
@Entity
public class PetsmartSheet extends Timesheet {

    /**
     * name.
     */
    @Id
    private String name;
    /**
     * email.
     */
    private String email;
    /**
     * project.
     */
    private String project;
    /**
     * notes.
     */
    private String notes;
    /**
     * LocalDateTime.
     */
    private LocalDateTime created;
    
    
    
    /**
     * @param email email.
     */
    public PetsmartSheet(final String email) {
        super();
        this.email = email;
    }
    /**
     * @return get email.
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email email.
     */
    public void setEmail(final String email) {
        this.email = email;
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
     * @return project.
     */
    public String getProject() {
        return project;
    }
    /**
     * @param project setProject.
     */
    public void setProject(final String project) {
        this.project = project;
    }
    /**
     * @param hoursWorked setHoursWorked.
     */
    public void setHoursWorked(final int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    /**
     * @return notes.
     */
    public String getNotes() {
        return notes;
    }
    /**
     * @param notes setnotes.
     */
    public void setNotes(final String notes) {
        this.notes = notes;
    }
    /**
     * @return localDate time.
     */
    public LocalDateTime getCreated() {
        return created;
    }
    /**
     * @param created created.
     */
    public void setCreated(final LocalDateTime created) {
        this.created = created;
    }
    /**
     * to string.
     */
    @Override
    public String toString() {
        return "" + name + ","+ hoursWorked +"," + "";
//    weekEnding + "";
    }
    /**
     * @param name name.
     * @param project project.
     * @param hoursWorked hoursWorked.
     * @param notes notes.
     * @param created created.
     */
    public PetsmartSheet(final String name, final String project, final int hoursWorked, final String notes,
            final LocalDateTime created) {
        super();
        this.name = name;
        this.project = project;
//        this.weekEnding = weekEnding;
        this.hoursWorked = hoursWorked;
        this.notes = notes;
        this.created = created;
      
    }
    /**
     * PetsmartSheet.
     */
    public PetsmartSheet() {
        // TODO Auto-generated constructor stub
    }
    
    
    
    
}
