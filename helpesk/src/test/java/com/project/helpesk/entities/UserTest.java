package com.project.helpesk.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserTest {
   
    int id=1;
    String firstName = "Parth";
    String lastName = "Waghela";
    int employeeId = 1;
    String email = "parthwaghela@gmail.com";
    String contact = "9855234567";
    String dob = "2000-12-10";
    String gender = "male";
    String role="role";
    String password = "123456";
    String city = "indore";
    String state = "madhya pradesh";
    String country = "india";
    String designation = "software";
    @Test
    public void testGetterSetter() {
    User user= new User(id, firstName,lastName,employeeId,email,contact,dob,gender,role,password,city,state,country,designation);
    user.setId(id);
    user.setFirstName(firstName);
    user.setEmployeeId(employeeId);
    user.setContact(contact);
    user.setEmail(email);
    user.setDob(dob);
    user.setGender(gender);
    user.setRole(role);
    user.setCity(city);
    user.setPassword(password);
    user.setState(state);
    user.setCountry(country);
    user.setDesignation(designation);
   
    assertEquals(1, user.getId());
    assertEquals(firstName, user.getFirstName());
    assertEquals(lastName, user.getLastName());
    assertEquals(email, user.getEmail());
    assertEquals(employeeId, user.getEmployeeId());
    assertEquals(contact, user.getContact());
    assertEquals(dob, user.getDob());
    assertEquals(role, user.getRole());
    assertEquals(city, user.getCity());
    assertEquals(password, user.getPassword());
    assertEquals(state, user.getState());
    assertEquals(country, user.getCountry());
    assertEquals(designation, user.getDesignation());


    
    
    }
   
   }