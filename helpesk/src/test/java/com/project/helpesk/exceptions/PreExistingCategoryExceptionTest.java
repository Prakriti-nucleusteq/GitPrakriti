package com.project.helpesk.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@SpringBootTest
@RunWith(SpringRunner.class)
class PreExistingCategoryExceptionTest {

	@Test
	void PreExistingCategoryException() {
		PreExistingCategoryException ex = new PreExistingCategoryException("Category already exists");
        assertEquals("Category already exists", ex.getMessage());
	}

}
