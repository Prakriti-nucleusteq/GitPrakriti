package com.timesheet.timesheet.entity;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PetsmartSheetTest {
    

    @BeforeEach
    void setUp() throws Exception {
    }
    
    @Test
    public void PetsmartSheetTest() {
        
        PetsmartSheet petsmart = new PetsmartSheet();
    
   String name = "prakriti";
   String email = "pg@gmail.com";
   String project = "project";
   String notes = "AA-01";
   LocalDateTime created=LocalDateTime.now();
   
   petsmart.setName(name);
   petsmart.setEmail(email);
   petsmart.setProject(project);
   petsmart.setNotes(notes);
   petsmart.setCreated(created);
   
   assertEquals(name, petsmart.getName());
   assertEquals(email, petsmart.getEmail());
   assertEquals(project, petsmart.getProject());
   assertEquals(notes, petsmart.getNotes());
   assertEquals(created, petsmart.getCreated());

    }

    @Test
    public void testGettersAndSetters() {
        PetsmartSheet petsmart = new PetsmartSheet();
        
        String name = "prakrti";
        petsmart.setName(name);
        assertEquals(name, petsmart.getName());
        
        String email ="pg@gmail.com" ;
        petsmart.setEmail(email);
        assertEquals(email, petsmart.getEmail());
        

        String project ="project" ;
        petsmart.setProject(project);
        assertEquals(project, petsmart.getProject());
        
        
        String notes ="AA-01" ;
        petsmart.setNotes(notes);
        assertEquals(notes, petsmart.getNotes());
}

}