package com.taa.project.scheduler.controllers;

import com.taa.project.scheduler.data.model.User;
import com.taa.project.scheduler.services.dto.UserDto;
import com.taa.project.scheduler.services.implementations.UserService;
import com.taa.project.scheduler.services.interfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {


    private ModelMapper modelMapper;

    private IUserService userService;

    @Autowired
    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserDto> usersDto = new ArrayList<>();

        for (User user : users) {
            usersDto.add(modelMapper.map(user, UserDto.class));
        }

        return ResponseEntity.ok().body(usersDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id) {
        User user = userService.getById(id);
        UserDto userResponse = modelMapper.map(user, UserDto.class);
        return ResponseEntity.ok().body(userResponse);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) throws Exception {
        try {
            User userRequest = modelMapper.map(userDto, User.class);
            User user = userService.addUser(userRequest);
            UserDto userResponse = modelMapper.map(user, UserDto.class);
            return new ResponseEntity<UserDto>(userResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            //User deja existant
            return new ResponseEntity<UserDto>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable long id, @RequestBody UserDto userDto) throws Exception {

        User userRequest = modelMapper.map(userDto, User.class);
        User user = userService.updateUser(id, userRequest);
        UserDto userResponse = modelMapper.map(user, UserDto.class);
        return ResponseEntity.ok().body(userResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") Long id) throws Exception {
        userService.deleteUser(id);
        return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
    }
}
