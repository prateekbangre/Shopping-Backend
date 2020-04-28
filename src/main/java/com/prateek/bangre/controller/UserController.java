package com.prateek.bangre.controller;

import com.prateek.bangre.model.ApiResponse;
import com.prateek.bangre.model.Users;
import com.prateek.bangre.model.UsersRequest;
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

//    @PostMapping
//    public ApiResponse<Users> saveUser(@RequestBody Users user){
//        return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",usersService.updateUsers(user));
//    }

    @GetMapping
    public ApiResponse<List<Users>> listUser(){
        return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.",usersService.findAllUsers());
    }

    @GetMapping("/{id}")
    public ApiResponse<Users> getOne(@PathVariable int id){
        return new ApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.",usersService.findUsersById(id));
    }

    @PostMapping("/{id}")
    public ApiResponse<Users> update(@PathVariable int id, @RequestBody UsersRequest usersRequest) {
        if (usersService.updateUsersWithUsersRequest(usersRequest, id) == 1){
            return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully.","");
        }else {
            return new ApiResponse<>(HttpStatus.OK.value(), "User updated Fail.",null);
        }
    }

//    @DeleteMapping("/{id}")
//    public ApiResponse<Void> delete(@PathVariable int id) {
//        usersService.deleteUsersById(id);
//        return new ApiResponse<>(HttpStatus.OK.value(), "User deleted successfully.", null);
//    }
}
