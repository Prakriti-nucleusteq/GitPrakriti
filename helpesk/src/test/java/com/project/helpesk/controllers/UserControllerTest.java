package com.project.helpesk.controllers;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.helpesk.dto.InputLoginDto;
import com.project.helpesk.dto.UserDto;
import com.project.helpesk.repositories.UserRepo;
import com.project.helpesk.services.UserService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.ArrayList;
import java.util.List;
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    @Mock
    private UserService userService;
    @Autowired
    private MockMvc mockMvc;
    @Mock
    UserRepo userRepository;
    @InjectMocks
    UserController userController;
    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }
    @Test
    public void createUserTest() throws Exception {
        MockitoAnnotations.openMocks(this);
        int id = 1;
        String firstName = "Ayush";
        String lastName = "Bamboriya";
        String email = "ayush@nucleusteq.com";
        String gender = "male";
        String password = "Ayush@123";
        String designation = "Software Engineer";
        String dob = "2022, 06, 06";
        int employeeId = 1;
        String contact = "8989878987";
        String city = "Indore";
        String country = "State";
        String role = "admin";
        String State = "State";
        UserDto userDto = buildUserDto(id, firstName, lastName, email, gender, password, designation, dob, State,
                employeeId, contact, city, country, role, State);
        UserDto userDto2 = new UserDto();
        userDto2.setId(id);
        userDto2.setFirstName(firstName);
        userDto2.setLastName(lastName);
        userDto2.setEmail(email);
        userDto2.setDob(dob);
        userDto2.setContact(contact);
        userDto2.setPassword(password);
        userDto2.setRole(role);
        userDto2.setEmployeeId(employeeId);
        userDto2.setCity(city);
        userDto2.setCountry(country);
        userDto2.setDesignation(designation);
        userDto2.setState(State);
        userDto2.setGender(gender);
        Mockito.when(userService.createUser(userDto)).thenReturn(userDto);
        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(userDto);
        System.out.println(inputJSON);
        System.out.print("message for test" + inputJSON);
        MvcResult mvcResult = this.mockMvc
                .perform(post("/api/users/create").contentType(MediaType.APPLICATION_JSON).content(inputJSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
    }
    private UserDto buildUserDto(int id, String firstName, String lastName, String email, String gender,
            String password, String designation, String dob, String state, int employeeId, String contact,
            String city, String country, String role, String state2) {
        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setCity(role);
        userDto.setContact(contact);
        userDto.setCountry(country);
        userDto.setDesignation(designation);
        userDto.setDob(dob);
        userDto.setEmail(email);
        userDto.setEmployeeId(employeeId);
        userDto.setFirstName(firstName);
        userDto.setGender(gender);
        userDto.setLastName(lastName);
        userDto.setPassword(password);
        userDto.setState(state);
        userDto.setRole(role);
        return userDto;
    }
    @Test
    public void loginUserTest() throws Exception {
        MockitoAnnotations.openMocks(this);
        String email = "email@nucleusteeq.com";
        String password = "password";
        int id = 1;
        String firstName = "firstName";
        String lastName = "lastName";
        String gender = "gender";
        String designation = "designation";
        String dob = "doj";
        int employeeId = 1;
        String contact = "contact";
        String city = "city";
        String country = "country";
        String role = "role";
        String State = "State";
        UserDto userDto = buildUserDto(id, firstName, lastName, email, gender, password, designation, dob, State,
                employeeId, contact, city, country, role, State);
        InputLoginDto inputLoginDto = new InputLoginDto();
        inputLoginDto.setEmail(email);
        inputLoginDto.setPassword(password);
        Mockito.when(userService.fetchUserByEmail(inputLoginDto)).thenReturn(userDto);
        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(inputLoginDto);
        MvcResult mvcResult = this.mockMvc
                .perform(post("/api/users/login").contentType(MediaType.APPLICATION_JSON).content(inputJSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
    private InputLoginDto buildUserLoginDto(String email, String password) {
        InputLoginDto inputLoginDto = new InputLoginDto();
        inputLoginDto.setEmail(email);
        inputLoginDto.setPassword(password);
        return null;
    }
    @Test
    public void updateUsertest() throws Exception {
        MockitoAnnotations.openMocks(this);
        int id = 1;
        String firstName = "Ayush";
        String lastName = "Bamboriya";
        String email = "ayush@nucleusteq.com";
        String gender = "male";
        String password = "Ayush@123";
        String designation = "Software Engineer";
        String doj = "2022, 06, 06";
        int employeeId = 1;
        String contact = "9898989898";
        String city = "Indore";
        String country = "State";
        String role = "admin";
        String State = "State";
        UserDto userDto = buildUserDto(id, firstName, lastName, email, gender, password, designation, doj, State,
                employeeId, contact, city, country, role, State);
        UserDto userDto2 = new UserDto();
        userDto2.setId(1);
        userDto2.setFirstName("Ayush");
        userDto2.setLastName("Bamboriya");
        userDto2.setEmail("ayush@nucleusteq.com");
        userDto2.setDob("2022, 06, 06");
        userDto2.setContact("9898989898");
        userDto2.setPassword("Ayush@123");
        userDto2.setRole("admin");
        userDto2.setEmployeeId(1);
        userDto2.setCity("Indore");
        userDto2.setCountry("State");
        userDto2.setDesignation("Software Engineer");
        userDto2.setState("MP");
        userDto2.setGender("male");
        Mockito.when(userService.updateUser(userDto, id)).thenReturn(userDto2);
        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(userDto);
        MvcResult mvcResult = this.mockMvc
                .perform(put("/api/users/1").contentType(MediaType.APPLICATION_JSON).content(inputJSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
    private UserDto buildUserDto1(int id, String firstName, String lastName, String email, String gender,
            String password, String designation, String doj, String state, String country, String contact,
            int employeeId, String role, String city) {
        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setCity(role);
        userDto.setContact(contact);
        userDto.setCountry(country);
        userDto.setDesignation(designation);
        userDto.setDob(doj);
        userDto.setEmail(email);
        userDto.setEmployeeId(employeeId);
        userDto.setFirstName(firstName);
        userDto.setGender(gender);
        userDto.setLastName(lastName);
        userDto.setPassword(password);
        userDto.setState(state);
        userDto.setRole(role);
        return userDto;
    }
    @Test
    public void getAllUserstest() throws Exception {
        MockitoAnnotations.openMocks(this);
        int id = 1;
        String firstName = "firstName";
        String lastName = "lastName";
        String email = "email";
        String gender = "gender";
        String password = "password";
        String designation = "designation";
        String doj = "doj";
        int employeeId = 1;
        String contact = "contact";
        String city = "city";
        String country = "country";
        String role = "role";
        String State = "State";
        UserDto userDto = buildUserDto(id, firstName, lastName, email, gender, password, designation, doj, State,
                employeeId, contact, city, country, role, State);
        List<UserDto> UserDtoList = new ArrayList<UserDto>();
        UserDtoList.add(userDto);
        Mockito.when(userService.getAllusers()).thenReturn(UserDtoList);
        ObjectMapper objectMapper = new ObjectMapper();
        String inputJSON = objectMapper.writeValueAsString(userDto);
        MvcResult mvcResult = this.mockMvc
                .perform(get("/api/users/all/").contentType(MediaType.APPLICATION_JSON).content(inputJSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
}