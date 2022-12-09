package com.timesheet.timesheet.entity;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TimesheetTest {


    
    @Test
    public void TimesheetTest() {
        Timesheet sheet = new Timesheet();
        double hoursWorked =20.0;
        Date timeForTheWeekEnding = new Date();
        
        sheet.setHoursWorked(hoursWorked);
        sheet.setTimeForTheWeekEnding(timeForTheWeekEnding);
        
         assertEquals(hoursWorked, sheet.getHoursWorked());
         assertEquals(timeForTheWeekEnding, sheet.getTimeForTheWeekEnding());
    }
    @Test
    public void testGettersAndSetters() {
        Timesheet sheet = new Timesheet();
        double hoursWorked =20.0;
        sheet.setHoursWorked(hoursWorked);
        assertEquals(hoursWorked, sheet.getHoursWorked());
        Date timesheetWeekEnding = new Date();
        sheet.setTimeForTheWeekEnding(timesheetWeekEnding);
        assertEquals(timesheetWeekEnding, sheet.getTimeForTheWeekEnding());
        }
   
}
