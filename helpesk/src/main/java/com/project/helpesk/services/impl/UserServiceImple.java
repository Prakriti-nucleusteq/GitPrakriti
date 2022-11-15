package com.project.helpesk.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.project.helpesk.config.AppConstants;
import com.project.helpesk.dto.InputLoginDto;

import com.project.helpesk.dto.UserDto;

import com.project.helpesk.entities.User;
import com.project.helpesk.entities.UserRole;

import com.project.helpesk.exceptions.ResourceNotFoundException;
import com.project.helpesk.exceptions.ValidationException;

import com.project.helpesk.repositories.UserRepo;
import com.project.helpesk.repositories.UserRoleRepo;
import com.project.helpesk.services.UserService;

/**
 * @author opera_ao6omsd
 *
 */
@Service
public final class UserServiceImple implements UserService {

    /**
     * user repo.
     *
     */
    @Autowired
    private UserRepo userRepo;

    /**
     * userRoleRepo.
     */
    @Autowired
    private UserRoleRepo userRoleRepo;

    /**
     * Model mapper.
     */
    @Autowired
    private ModelMapper modelMapper;

    /**
     * createUser UserDto.
     */
    @Override
    public UserDto createUser(final UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());

        int userRoleId = user.getId();
        System.out.print(user.getId());
        String userRoleName = user.getRole();
        System.out.print(userRoleName);
        String admin = "admin";
        UserRole userRole = new UserRole();
        userRole.setUserId(userRoleId);
        if (userRoleName.equals(admin)) {
            userRole.setRoleId(AppConstants.ADMIN_USER);
        } else {
            userRole.setRoleId(AppConstants.NORMAL_USER);
        }

        this.userRoleRepo.save(userRole);
        System.out.print(userRoleName);
        return this.userToDto(savedUser);
    }

    /**
     * userDto.
     */
    /**
     * updateUser.
     */
    @Override
    public UserDto updateUser(final UserDto userDto, final Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setContact(userDto.getContact());
        user.setDob(userDto.getDob());
        user.setGender(userDto.getGender());
        User updatedUser = this.userRepo.save(user);
        UserDto userDtol = this.userToDto(updatedUser);
        return userDtol;
    }

    /**
     * getUserById.
     */
    @Override
    public UserDto getUserById(final Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        return this.userToDto(user);
    }

    /**
     * @return userDto.
     */
    @Override
    public List<UserDto> getAllusers() {
        List<User> users = this.userRepo.findAll();

        List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    /**
     * return delete user.
     */
    @Override
    public void deleteUser(final Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        this.userRepo.delete(user);

    }

    /**
     * @param userDto get the user dto.
     * @return user.
     */
    public User dtoToUser(final UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);

        return user;
    }

    /**
     * @param user user.
     * @return userDto.
     */
    public UserDto userToDto(final User user) {
        UserDto userDto = this.modelMapper.map(user, UserDto.class);

        return userDto;
    }

    /**
     * @param inputLoginDTO input login DTO
     * @return UserDTO login implementation.
     */
    public UserDto fetchUserByEmail(final InputLoginDto inputLoginDTO) {
        if (StringUtils.isEmpty(inputLoginDTO.getEmail()) || StringUtils.isEmpty(inputLoginDTO.getPassword())) {
            throw new ValidationException("Email or password cannot be empty");
        }
        User user = userRepo.findByEmail(inputLoginDTO.getEmail())
                .orElseThrow(() -> new ValidationException("User not found."));
        if (!Objects.equals(user.getPassword(), inputLoginDTO.getPassword())) {
            throw new ValidationException("Incorrect Username & Password");
        }

        UserDto userDTO = new UserDto();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setEmployeeId(user.getEmployeeId());
        userDTO.setContact(user.getContact());

        userDTO.setLastName(user.getLastName());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setDob(user.getDob());
        userDTO.setRole(user.getRole());
        UserRole userRole = userRoleRepo.findById(user.getId());

        int rid = userRole.getRoleId();

        if (rid == 501) {
            userDTO.setGender("Admin");
        } else {
            userDTO.setGender("Employee");
        }

        return userDTO;
    }

}
