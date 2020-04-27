package com.prateek.bangre.controller;

import com.prateek.bangre.model.ApiResponse;
import com.prateek.bangre.model.Users;
import com.prateek.bangre.run.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author prateek.bangre on 26/04/20.
 * @Project Shoping-Backend
 */
@RestController
@RequestMapping("/api/users")
public class UserController  {

    @Autowired
    private UsersService usersService;

    @PostMapping
    public ApiResponse<Users> saveUser(@RequestBody Users user){
        return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",usersService.updateUsers(user));
    }

    @GetMapping
    public ApiResponse<List<Users>> listUser(){
        return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.",usersService.findAllUsers());
    }

    @GetMapping("/{id}")
    public ApiResponse<Users> getOne(@PathVariable int id){
        return new ApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.",usersService.findUsersById(id));
    }

    @PutMapping("/{id}")
    public ApiResponse<Users> update(@RequestBody Users userDto) {
        return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully.",usersService.updateUsers(userDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable int id) {
        usersService.deleteUsersById(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "User deleted successfully.", null);
    }
}
