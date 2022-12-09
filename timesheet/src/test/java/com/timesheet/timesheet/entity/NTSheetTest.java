package com.timesheet.timesheet.entity;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class NTSheetTest {
    
    @BeforeEach
    void setUp() throws Exception {
    }
    
    @Test
    public void NtTimesheetTest() {
        
    NTSheet ntTimesheet = new NTSheet();
    
    LocalDateTime timeStamp = LocalDateTime.now();
    String userName = "prakrti";
    String email = "pg@gmail.com";
    String petSmartProgramThatYouSupport = "AA-01";
    String additionalComments = "abc";

             ntTimesheet.setTimeStamp(timeStamp);
             ntTimesheet.setUserName(userName);
             ntTimesheet.setEmail(email);
             ntTimesheet.setPetSmartProgramThatYouSupport(petSmartProgramThatYouSupport);
             ntTimesheet.setAdditionalComments(additionalComments);
             assertEquals(timeStamp, ntTimesheet.getTimeStamp());
             assertEquals(userName, ntTimesheet.getUserName());
             assertEquals(email, ntTimesheet.getEmail());
             assertEquals(petSmartProgramThatYouSupport, ntTimesheet.getPetSmartProgramThatYouSupport());
             assertEquals(additionalComments, ntTimesheet.getAdditionalComments());
        }
        @Test
        public void testGettersAndSetters() {
            NTSheet ntTimesheet = new NTSheet();
            
            String userName = "prakrti";
            ntTimesheet.setUserName(userName);
            assertEquals(userName, ntTimesheet.getUserName());
            
            String email ="pg@gmail.com" ;
            ntTimesheet.setEmail(email);
            assertEquals(email, ntTimesheet.getEmail());
            
            String petSmartProgramThatYouSupport ="AA-01";
            ntTimesheet.setPetSmartProgramThatYouSupport(petSmartProgramThatYouSupport);
            assertEquals(petSmartProgramThatYouSupport, ntTimesheet.getPetSmartProgramThatYouSupport());
            
            String additionalComments= "comments";
            ntTimesheet.setAdditionalComments(additionalComments);
            assertEquals(additionalComments, ntTimesheet.getAdditionalComments());
        }
    }

