package com.project.helpesk.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.project.helpesk.entities.User;

class AddCategoryResponseDtoTest {

	 @Test
	   public void AddCategoryResponseDtoTest() {
		 
		 AddCategoryResponseDto addCategoryResponseDto =new AddCategoryResponseDto();
	       Integer objId = 6;
	       Boolean success = true;
	       String message = "hello";
	       
	       addCategoryResponseDto.setObjId(objId);
	       addCategoryResponseDto.setSuccess(success);
	       addCategoryResponseDto.setMessage(message);

	       
	       assertEquals(6,addCategoryResponseDto.getObjId());
	       assertEquals(true,addCategoryResponseDto.getSuccess());
	       assertEquals(message,addCategoryResponseDto.getMessage());
	       
	   }
	 
//	 @Test
//	   public void testGettersAndSetters() {
//		 AddCategoryResponseDto addCategoryResponseDto =new AddCategoryResponseDto();
//	    assertNull(addCategoryResponseDto.getEmail());
//	    String email = "email";
//	    addCategoryResponseDto.setEmail(email);
//	    assertEquals(email, addCategoryResponseDto.getEmail());
//	   }
}
