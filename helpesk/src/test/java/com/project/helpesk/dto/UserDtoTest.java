package com.project.helpesk.dto;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//class UserDtoTest {
//
//	@Test
//	public void UserDtoTest1() {
//	int id = 1;
//	String firstName = "prakriti";
//	String lastName = "gupta";
//	String dob = "25";
//	String gender = "female";
//	String email ="prakriticom";
//	String password = "Prakriiti@29";
//	String contact = "8366429864";
//	
//	UserDto userdto = new UserDto();
//	userdto.setId(id);
//	userdto.setFirstName(firstName);
//	userdto.setLastName(lastName);
//	userdto.setDob(dob);
//	userdto.setGender(gender);
//	userdto.setEmail(email);
//	userdto.setPassword(password);
//	userdto.setContact(contact);
//	
//	assertEquals(id, userdto.getId());
//	assertEquals(firstName, userdto.getFirstName());
//	assertEquals(lastName,userdto.getLastName());
//	assertEquals(dob,userdto.getDob());
//	assertEquals(gender,userdto.getGender());
//	assertEquals(email,userdto.getEmail());
//	assertEquals(password, userdto.getPassword());
//	assertEquals(contact,userdto.getContact());
//	
//	}
//}

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import com.project.helpesk.dto.UserDto;
import com.project.helpesk.entities.User;
public class UserDtoTest {
    /**
    * To test the userDto class.
    */
   @Test
   public void userDtoTest() {
       UserDto userDto =new UserDto();
       int Id = 6;
       String firstname = "firstname";
       String lastname = "lastname";
       int employeeId = 1;
       String email ="email@email.com";
       String password = "password";
       String contact = "contact";
       String role = "Employee";
       String designation = "designation";
       String dob = "dateOfJoining";
       String gender = "dateOfExit";
       String city = "designation";
       String country = "dateOfJoining";
       String state = "state";
       
       userDto.setId(Id);
       userDto.setFirstName(firstname);
       userDto.setLastName(lastname);
       userDto.setEmployeeId(employeeId);
       userDto.setEmail(email);
       userDto.setPassword(password);
       userDto.setContact(contact);
       userDto.setRole(role);
       userDto.setDesignation(designation);
       userDto.setDob(dob);
       userDto.setGender(gender);
       userDto.setCity(city);
       userDto.setCountry(country);
       userDto.setState(state);
       
       assertEquals(6,userDto.getId());
       assertEquals(firstname,userDto.getFirstName());
       assertEquals(lastname,userDto.getLastName());
       assertEquals(employeeId,userDto.getEmployeeId());
       assertEquals(email,userDto.getEmail());
       assertEquals(password,userDto.getPassword());
       assertEquals(contact,userDto.getContact());
       assertEquals(role,userDto.getRole());
       assertEquals(designation,userDto.getDesignation());
       assertEquals(dob,userDto.getDob());
       assertEquals(gender,userDto.getGender());
       assertEquals(city,userDto.getCity());
       assertEquals(country,userDto.getCountry());
       assertEquals(state,userDto.getState());
   }
   @Test
   public void testGettersAndSetters() {
    User userDto =new User();
    assertNull(userDto.getEmail());
    String email = "email";
    userDto.setEmail(email);
    assertEquals(email, userDto.getEmail());
   }
   @Test
   public void testToString() {
    UserDto user =new UserDto();
       int Id = 6;
       String firstName = "firstname";
       String lastName = "lastname";
       int employeeId = 2;
       String email ="email@email.com";
       String password = "password";
       String contact = "contact";
       String role = "Admin";
       String designation = "designation";
       String dob ="dateOfBirth";
       String gender = "gender";
       String city = "city";
       String country = "country";
       String state = "state";
       
       UserDto userEntity = buildUserDto(Id, firstName,lastName, employeeId,
            email,password, contact,role,designation, dob,
            gender, city,country, state);
       UserDto userEntity1 = buildUserDto(Id, firstName,lastName, employeeId,
               email,password, contact,role,designation, dob,
               gender, city,country, state);
       String tostring = userEntity1.toString();
       assertEquals(false, userEntity.equals(null));
       assertEquals(true,userEntity.equals(userEntity1));
   }
//   @Test
//   public void testEqualsAndHashCode() {
//           int Id = 6;
//          String firstName = "firstname";
//          String lastName = "lastname";
//          int employeeId = 2;
//          String email ="email@email.com";
//          String password = "password";
//          String contact = "contact";
//          String role = "Employee";
//          String designation = "designation";
//          String dob = "dateOfJoining";
//          String gender = "gender";
//          String city = "city";
//          String country = "country";
//          String state = "state";
//
//          UserDto newObj2 =new UserDto();
//          newObj2.setId(Id);
//          newObj2.setFirstName(firstName);
//          newObj2.setLastName(lastName);
//          newObj2.setEmployeeId(employeeId);
//          newObj2.setEmail(email);
//          newObj2.setPassword(password);
//          newObj2.setContact(contact);
//          newObj2.setRole(role);
//          newObj2.setDesignation(designation);
//          newObj2.setDob(dob);
//          newObj2.setGender(gender);
//          newObj2.setCity(city);
//          newObj2.setCountry(country);
//          newObj2.setState(state);
//          
//          UserDto newObj = new UserDto();
//          newObj.setId(Id);
//          newObj.setFirstName(firstName);
//          newObj.setLastName(lastName);
//          newObj.setEmployeeId(employeeId);
//          newObj.setEmail(email);
//          newObj.setPassword(password);
//          newObj.setContact(contact);
//          newObj.setRole(role);
//          newObj.setDesignation(designation);
//          newObj.setDob(dob);
//          newObj.setGender(gender);
//          newObj.setCity(city);
//          newObj.setCountry(country);
//          newObj.setState(state);
//          assertEquals(newObj,newObj2);
//   }
   public UserDto buildUserDto(int id, String firstName, String lastName,
        int employeeId, String email, String password,
        String contact,String role, String designation,
        String dob, String gender, String city,
        String country, String state) {
       UserDto userEntity = new UserDto();
    userEntity.setId(id);
    userEntity.setFirstName(firstName);
    userEntity.setLastName(lastName);
    userEntity.setEmployeeId(employeeId);
    userEntity.setEmail(email);
    userEntity.setPassword(password);
    userEntity.setDob(dob);
    userEntity.setContact(contact);
    userEntity.setDesignation(designation);
    userEntity.setCity(city);
    userEntity.setState(state);
    userEntity.setRole(role);
    userEntity.setGender(gender);
    userEntity.setCountry(country);
    return userEntity;
   }
}
