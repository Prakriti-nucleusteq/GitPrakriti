package com.project.helpesk.services;

import java.util.List;

import com.project.helpesk.dto.InputLoginDto;
import com.project.helpesk.dto.UserDto;

/**
 * @author opera_ao6omsd
 *
 */
public interface UserService {
    /**
     * @param user create the user
     * @return it return the User data
     */
    UserDto createUser(UserDto user);

    /**
     * @param user   update the user
     * @param userId update the user id
     * @return get the userdto and interger
     */
    UserDto updateUser(UserDto user, Integer userId);

    /**
     * @param userId get the value of id
     * @return get the user by id
     */
    UserDto getUserById(Integer userId);

    /**
     * @return list of UserDto
     */
    List<UserDto> getAllusers();

    /**
     * @param userId delete the value by id
     */
    void deleteUser(Integer userId);

    /**
     * @param inputLoginDTO input login.
     * @return fetchUserByEmail.
     */
    UserDto fetchUserByEmail(InputLoginDto inputLoginDTO);
}
