package com.project.helpesk.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputLoginDtoTest {
 
	
	@Test
	   public void InputLoginDtoTest() {
		 
		InputLoginDto inputLoginDto =new InputLoginDto();
	       
	       String email = "prakriti@nucleusteq.com";
	       String password = "prakriti@1234";
	       
	       inputLoginDto.setEmail(email);;
	       inputLoginDto.setPassword(password);
	

	       
	       assertEquals(email,inputLoginDto.getEmail());
	       assertEquals(password,inputLoginDto.getPassword());
	
	
	   }
}
