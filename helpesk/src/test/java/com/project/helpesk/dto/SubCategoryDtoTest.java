package com.project.helpesk.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.project.helpesk.entities.Subcategory;
import com.project.helpesk.entities.User;

class SubCategoryDtoTest {


	@Test
	   public void SubCategoryDtoTest() {
		 
		SubCategoryDto subCategoryDto =new SubCategoryDto();
	       Integer subId = 2;
	       String subCategoryName = "prakriti";
	       Integer categoryId = 2;
	       

	       subCategoryDto.setSubId(subId);
	       subCategoryDto.setSubcategoryName(subCategoryName);;
	       subCategoryDto.setCategoryId(categoryId);;
	       
	       assertEquals(2,subCategoryDto.getSubId());
	       assertEquals(subCategoryName,subCategoryDto.getSubcategoryName());
	       assertEquals(2,subCategoryDto.getCategoryId());
	 

	   }
	 @Test
	   public void testGettersAndSetters() {
	    Subcategory subcategory =new Subcategory();
	    assertNull(subcategory.getSubcategoryName());
	    String email = "email";
	    subcategory.setSubcategoryName(email);;
	    assertEquals(email, subcategory.getSubcategoryName());
	   }
}
