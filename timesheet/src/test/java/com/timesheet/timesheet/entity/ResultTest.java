package com.timesheet.timesheet.entity;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ResultTest {

    
    @BeforeEach
    void setUp() throws Exception {
    }
    
    @Test
    public void ResultTest() {
        
    Result result = new Result();
    
     String name = "prakriti";
     int disturbance = 4;
     
     result.setName(name);
     result.setDisturbance(disturbance);
     assertEquals(name, result.getName());
     assertEquals(disturbance, result.getDisturbance());
    }
    
    @Test
    public void testGettersAndSetters() {
        Result result = new Result();
        
        String name = "prakrti";
        result.setName(name);
        assertEquals(name, result.getName());
        
        int disturbance = 5;
        result.setDisturbance(disturbance);
        assertEquals(disturbance, result.getDisturbance());
}
}