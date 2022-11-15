//package com.project.helpesk.services.impl;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import com.example.helpdesk.dto.TicketDto;
//import com.example.helpdesk.dto.UserDto;
//import com.example.helpdesk.dto.UserLoginDto;
//import com.example.helpdesk.dto.UserRoleDto;
//import com.example.helpdesk.model.Ticket;
//import com.example.helpdesk.model.User;
//import com.example.helpdesk.model.UserRole;
//import com.example.helpdesk.repo.UserRepository;
//import com.example.helpdesk.repo.UserRoleRepository;
//import com.jayway.jsonpath.Option;
//import com.project.helpesk.dto.InputLoginDto;
//import com.project.helpesk.dto.UserDto;
//import com.project.helpesk.entities.User;
//import com.project.helpesk.entities.UserRole;
//import com.project.helpesk.repositories.UserRepo;
//import com.project.helpesk.repositories.UserRoleRepo;
//
//import java.util.stream.Stream;
//class UserServiceImpleTest {
//    @Mock
//    UserRepo userRepository;
//    @Mock
//    UserRoleRepo roleRepository;
//    @InjectMocks
//    UserServiceImple userServiceImple;
//    @Test
//    void createUsertest() {
//        MockitoAnnotations.openMocks(this);
//        UserDto userDto = new UserDto(1, "Ayush", "Bamboriya", 1,"abc@nucleusteq.com",
//                "AYush@123", "9090909090", 
//                "Admin","2022,07,07", "Male", "Indore", "India", "engineer", "MP" );
//        User user = new User(1, "Ayush", "Bamboriya", 1,"abc@nucleusteq.com", "AYush@123", "9090909090",  "Admin",
//                "2022,07,07","Male","Indore", "India", "engineer", "MP" );
//        Mockito.when(userRepository.save(user)).thenReturn(user);
//        UserRole userRole = new UserRole(0, 0);
//        Mockito.when(roleRepository.save(userRole)).thenReturn(null);
//        assertEquals(userDto, userServiceImple.createUser(userDto));
//    }
//    @Test
//    void updateUserTest() {
//        MockitoAnnotations.openMocks(this);
//        UserDto userDto = new UserDto(1, "Ayush", "Bamboriya", 1,"abc@nucleusteq.com",
//                "AYush@123", "9090909090", 
//                "Admin","2022,07,07", "Male", "Indore", "India", "engineer", "MP" );
//        User user1 = new User(1, "Ayush", "Bamboriya", 1,"abc@nucleusteq.com", "AYush@123", "9090909090",  "Admin",
//                "2022,07,07","Male","Indore", "India", "engineer", "MP" );
//        Optional<User> opUser = Optional.of(user1);
//        Mockito.when(userRepository.findById(1)).thenReturn(opUser);
//        User userupdate = new User(1, "Ayush", "Bamboriya", 1,"abc@nucleusteq.com", "AYush@123", "9090909090",  "Admin",
//                "2022,07,07","Male","Indore", "India", "engineer", "MP" );
//        UserDto userupdatedto = new UserDto(1, "Ayush", "Bamboriya", 1,"abc@nucleusteq.com", "AYush@123", "9090909090",  "Admin",
//                "2022,07,07","Male","Indore", "India", "engineer", "MP" );
//        Mockito.when(userRepository.save(userupdate)).thenReturn(userupdate);
//        assertEquals(userupdatedto, userServiceImple.updateUser(userDto, 1));
//    }
//    @Test
//    void getUserByIdTest() {
//        MockitoAnnotations.openMocks(this);
//        User user = new User(1, "Ayush", "Bamboriya", 1,"abc@nucleusteq.com", "AYush@123", "9090909090",  "Admin",
//                "2022,07,07","Male","Indore", "India", "engineer", "MP" );
//        UserDto userDto = new UserDto(1, "Ayush", "Bamboriya", 1,"abc@nucleusteq.com", "AYush@123", "9090909090",  "Admin",
//                "2022,07,07","Male","Indore", "India", "engineer", "MP" );
//        Optional<User> user1 = Optional.of(user);
//        Mockito.when(userRepository.findById(1)).thenReturn(user1);
//        assertEquals(userDto, userServiceImple.getUserById(1));
//    }
//    @Test
//    void getAllusersTest() {
//        MockitoAnnotations.openMocks(this);
//        List<UserDto> UserDtoList = new ArrayList<UserDto>();
//        Mockito.when(userRepository.findAll())
//                .thenReturn(Stream
//                        .of(new User(1, "Ayush", "Bamboriya", 1,"abc@nucleusteq.com", "AYush@123", "9090909090",  "Admin",
//                                "2022,07,07","Male","Indore", "India", "engineer", "MP" ))
//                        .collect(Collectors.toList()));
//        assertEquals(1, userServiceImple.getAllusers().size());
//    }
//    @Test
//    void fetchUserByEmailTest() {
//        MockitoAnnotations.openMocks(this);
//        User user = new User(1, "Ayush", "Bamboriya", 1,"abc@nucleusteq.com", "AYush@123", "9090909090",  "Admin",
//                "2022,07,07","Male","Indore", "India", "engineer", "MP" );
//        List<User> userList = new ArrayList<User>();
//        userList.add(user);
//        UserDto userDto = new UserDto(1, "Ayush", "Bamboriya", 1,"abc@nucleusteq.com", "AYush@123", "9090909090",  "Admin",
//                "2022,07,07","Male","Indore", "India", "engineer", "MP" );
//        Mockito.when(userRepository.findAll()).thenReturn(userList);
//        InputLoginDto userloginDto = new InputLoginDto();
//        userloginDto.setEmail("abc@nucleusteq.com");
//        userloginDto.setPassword("AYush@123");
//        assertEquals(userDto, userServiceImple.fetchUserByEmail(userloginDto));
//    }
//}