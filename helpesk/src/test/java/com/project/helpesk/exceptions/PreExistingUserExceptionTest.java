package com.project.helpesk.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class PreExistingUserExceptionTest {

	@Test
	void PreExistingUserException() {
		PreExistingUserException ex = new PreExistingUserException("User already exists");
        assertEquals("User already exists", ex.getMessage());
	}

}
