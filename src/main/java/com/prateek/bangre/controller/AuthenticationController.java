package com.prateek.bangre.controller;

import com.prateek.bangre.config.JwtToken;
import com.prateek.bangre.model.ApiResponse;
import com.prateek.bangre.model.LoginResponse;
import com.prateek.bangre.model.Users;
import com.prateek.bangre.model.UsersRequest;
import com.prateek.bangre.run.service.JwtUserDetailsService;
import com.prateek.bangre.run.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author prateek.bangre on 28/04/20.
 * @Project Shoping-Backend
 */
@RestController
@RequestMapping("api/auth")
public class AuthenticationController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtToken jwtToken;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @PostMapping("/login")
    public ApiResponse<LoginResponse> createAuthenticationToken(@RequestBody UsersRequest authenticationRequest) throws Exception {

        String msg = authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        if (msg.equals("Credential match")){
            final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
            final String token = jwtToken.generateToken(userDetails);
            LoginResponse response = LoginResponse.builder()
                                        .token(token)
                                        .auth(true)
                                        .email(authenticationRequest.getEmail())
                                        .username(authenticationRequest.getUsername())
                                        .build();
            return new ApiResponse(HttpStatus.OK.value(), "Successfully", response);
        }else {
            return new ApiResponse(HttpStatus.OK.value(), msg, "");
        }
    }

    private String authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return "Credential match";
        } catch (Exception e) {
            return "Credential not-match";
        }
    }

    @PostMapping("/register")
    public ApiResponse<String> registerNewUser(@RequestBody UsersRequest usersRequest){

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
