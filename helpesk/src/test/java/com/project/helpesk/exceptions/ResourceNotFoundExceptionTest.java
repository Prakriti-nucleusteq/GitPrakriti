package com.project.helpesk.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResourceNotFoundExceptionTest {

	@Test
	void ResourceNotFoundException() {
		ResourceNotFoundException ex = new ResourceNotFoundException("User already exists", "message", 0);
//        assertEquals("User already exists", ex.getMessage());
//        assertEquals("message", ex.getMessage());
//        assertEquals(0, ex.getMessage());
        assertEquals("User already exists not found with message : 0", ex.getMessage());

	}

}
