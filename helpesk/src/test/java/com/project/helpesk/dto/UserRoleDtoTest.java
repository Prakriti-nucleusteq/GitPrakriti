package com.project.helpesk.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

import com.project.helpesk.entities.User;
import com.project.helpesk.entities.UserRole;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
//import org.junit.jupiter.api.Test;

class UserRoleDtoTest {

@Test
public void userRoleDtoTest() {
    UserRoleDto userDto =new UserRoleDto();
    int Id = 6;
    int roleId = 6;
    int userId =6;
    
    userDto.setId(Id);
    userDto.setRoleId(Id);
    userDto.setUserId(userId);
    
    assertEquals(6,userDto.getId());
    assertEquals(6,userDto.getRoleId());
    assertEquals(6,userDto.getUserId());
    }
//@Test
//public void testGettersAndSetters() {
// UserRole userrole =new UserRole();
// assertNull(userrole.getId());
//  int id = 1;
// userrole.setId(id);
// assertEquals(id, userrole.getId());
//}


}
