package com.project.helpesk.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class ValidationExceptionTest {

    @Test
    public void ValidationException() {
        ValidationException ex = new ValidationException("Email or password cannot be empty");
        assertEquals("Email or password cannot be empty", ex.getMessage());
    }


}
