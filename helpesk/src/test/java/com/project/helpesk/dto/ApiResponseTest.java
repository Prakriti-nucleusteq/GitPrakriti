package com.project.helpesk.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApiResponseTest {

	@Test
	   public void ApiResponseTest() {
		 
		ApiResponse apiResponse =new ApiResponse();
	
	       Boolean success = true;
	       String message = "hello";
	       
	       apiResponse.setSuccess(success);
	       apiResponse.setMessage(message);

	       
	       assertEquals(true,apiResponse.isSuccess());
	       assertEquals(message,apiResponse.getMessage());
	       
	   }

}
