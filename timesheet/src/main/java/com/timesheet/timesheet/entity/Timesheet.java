package com.timesheet.timesheet.entity;
import java.util.Date;
import javax.persistence.MappedSuperclass;
/**
 * @author opera_ao6omsd Timesheet.
 *
 */
@MappedSuperclass
public class Timesheet {
    /**
     * hoursWorked.
     */
    public double hoursWorked;
    /**
     * timeForTheWeekEnding.
     */
    public Date timeForTheWeekEnding;
    
    
    /**
     * @return getHoursWorked.
     */
    public double getHoursWorked() {
        return hoursWorked;
    }
    /**
     * @param hoursWorked setHoursWorked.
     */
    public void setHoursWorked(final double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    /**
     * @return getTimeForTheWeekEnding.
     */
    public Date getTimeForTheWeekEnding() {
        return timeForTheWeekEnding;
    }
    /**
     * @param timeForTheWeekEnding setTimeForTheWeekEnding.
     */
    public void setTimeForTheWeekEnding(final Date timeForTheWeekEnding) {
        this.timeForTheWeekEnding = timeForTheWeekEnding;
    }
    /**
     * @param hoursWorked hoursWorked.
     * @param timeForTheWeekEnding timeForTheWeekEnding.
     */
    public Timesheet(final double hoursWorked, final Date timeForTheWeekEnding) {
        super();
        this.hoursWorked = hoursWorked;
        this.timeForTheWeekEnding = timeForTheWeekEnding;
    }
    /**
     * timesheet.
     */
    public Timesheet() {
        // TODO Auto-generated constructor stub
    }
    
    
}