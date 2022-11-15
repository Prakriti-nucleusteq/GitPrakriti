package com.project.helpesk.controllers;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.helpesk.dto.ApiResponse;
import com.project.helpesk.dto.InputLoginDto;
import com.project.helpesk.dto.UserDto;
import com.project.helpesk.services.UserService;

/**
 * @author opera_ao6omsd Rest Controller is used for define the Controller
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public final class UserController {

    /**
     * UserService.
     */
    @Autowired
    private UserService userService;

    // POST - create user
    /**
     * @param userDto userDto. ResponseEntity represents the whole HTTP response.
     * @return create user.
     */
    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody final UserDto userDto) {
        UserDto createUserDto = userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    /**
     * @param userDto get the userDto.
     * @param uid     uid.
     * @return put update user.
     */
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody final UserDto userDto,
            @PathVariable("userId") final Integer uid) {
        UserDto updatedUser = userService.updateUser(userDto, uid);
        return ResponseEntity.ok(updatedUser);

    }

    /**
     * @param uid uid.
     * @return delete user.
     */
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") final Integer uid) {
        this.userService.deleteUser(uid);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
    }

    /**
     * @return get all user.
     */
    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(this.userService.getAllusers());
    }

    /**
     * @param userId userid.
     * @return single user.
     */
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUsers(@PathVariable final Integer userId) {
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }

    /**
     * @param inputLoginDTO input login dto.
     * @return userService.
     */
    @PostMapping("/login")
    public UserDto login(@RequestBody final InputLoginDto inputLoginDTO) {
        return userService.fetchUserByEmail(inputLoginDTO);
    }

}
