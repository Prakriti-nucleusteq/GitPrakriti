package com.timesheet.timesheet.Exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class FileNotFoundExceptionTest {

    @Test
    public void FileNotFoundException() {
        FileNotFoundException ex = new FileNotFoundException("file not found");
        assertEquals("file not found", ex.getMessage());
    }

}
