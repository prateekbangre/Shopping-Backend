package com.prateek.bangre.controller;

import com.prateek.bangre.model.ApiResponse;
import com.prateek.bangre.model.LoginResponse;
import com.prateek.bangre.model.Users;
import com.prateek.bangre.model.UsersRequest;
import com.prateek.bangre.run.service.UsersService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

import static com.prateek.bangre.util.SecurityUtil.*;

/**
 * @author prateek.bangre on 28/04/20.
 * @Project Shoping-Backend
 */
@RestController
@RequestMapping("api/auth")
public class AuthenticationController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/login")
    ApiResponse<String> checkLogin(@RequestBody UsersRequest usersRequest){

        String msg = isPasswordAndUserMatch(usersRequest.getEmail(), usersRequest.getPassword(), usersService);
        String token = Jwts.builder()
                .setSubject("users/TzMUocMF4p")
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .claim("state", "true")
                .claim("email", usersRequest.getEmail())
                .claim("username", usersRequest.getUsername())
                .signWith(
                        SignatureAlgorithm.HS512,
                        SECRET
                )
                .compact();

        LoginResponse response = LoginResponse.builder()
                .token(token)
                .auth(true)
                .email(usersRequest.getEmail())
                .username(usersRequest.getUsername())
                .build();
        if (msg.isEmpty()){
            return new ApiResponse(HttpStatus.OK.value(), "Successfully", response);
        }else {
            return new ApiResponse(HttpStatus.OK.value(), msg, "");
        }
    }

    @PostMapping("/register")
    ApiResponse<String> registerNewUser(@RequestBody UsersRequest usersRequest){

        String msg = "";
        if (usersRequest.getEmail() == null){
            msg = "Email Field cann't be empty";
        }else if (usersRequest.getPassword() == null){
            msg = "Password Field cann't be empty";
        }else {
            Users user = usersService.findUsersByEmail(usersRequest.getEmail());
            if (user != null){
                msg = "Email/Username already exists, choose another one.";
            }else {
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
                String encodedPassword = passwordEncoder.encode(usersRequest.getPassword());
                usersService.updateUsers(Users.builder()
                        .email(usersRequest.getEmail())
                        .password(encodedPassword)
                        .username(usersRequest.getUsername())
                        .fname(usersRequest.getFname())
                        .lname(usersRequest.getLname())
                        .role(555)
                        .type(usersRequest.getType())
                        .build());
            }
        }
        if (msg.isEmpty()){
            return new ApiResponse(HttpStatus.OK.value(), "Registration successful.", "");
        }else {
            return new ApiResponse(HttpStatus.OK.value(), msg, "");
        }
    }


}
