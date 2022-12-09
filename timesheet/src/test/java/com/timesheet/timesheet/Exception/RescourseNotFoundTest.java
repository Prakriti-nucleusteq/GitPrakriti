package com.timesheet.timesheet.Exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RescourseNotFoundTest {

    @Test
    public void RescourseNotFound() {
        RescourseNotFound ex = new RescourseNotFound("Resource not found");
        assertEquals("Resource not found", ex.getMessage());
    }
}
