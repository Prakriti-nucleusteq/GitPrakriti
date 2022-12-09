package com.timesheet.timesheet.entity;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
public class EmployeeTest {

    String name = "Prakriiti";
    String email = "pg@gmail.com";
    
    public void testGetterSetter() {
        Employee user= new Employee(name, email);
        user.setName(name);
        user.setEmail(email);
        assertEquals(name, user.getName());
        assertEquals(email, user.getEmail());
    }
    
    @Test
    public void testGettersAndSetters() {
        Employee user= new Employee();        
        String name = "prakrti";
        user.setName(name);
        assertEquals(name, user.getName());
        
        String email ="pg@gmail.com" ;
        user.setEmail(email);
        assertEquals(email, user.getEmail());
    }}