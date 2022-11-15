package com.project.helpesk.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.project.helpesk.entities.Role;
import com.project.helpesk.entities.User;

class RoleDtoTest {



	   @Test
	   public void RoleDtoTest() {
		   RoleDto roleDto =new RoleDto();
	       int Id = 6;
	       String name = "firstname";
	       
	       
	       roleDto.setId(Id);
	       roleDto.setName(name);
	       assertEquals(6,roleDto.getId());
	       assertEquals(name,roleDto.getName());
	   }
	   
	   @Test
	   public void testGettersAndSetters() {
	    Role role =new Role();
	    assertNull(role.getName());
	    String name = "firstname";
	    role.setName(name);
	    assertEquals(name, role.getName());
	    
	   }
}
