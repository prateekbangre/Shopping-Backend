package com.prateek.bangre.util;

import com.prateek.bangre.model.Users;
import com.prateek.bangre.run.service.UsersService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author prateek.bangre on 28/04/20.
 * @Project Shoping-Backend
 */
public class SecurityUtil {

    public static final String SECRET = "1SBz93MsqTs7KgwARcB0I0ihpILIjk3w";
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;


    public static String isPasswordAndUserMatch(String email, String textPassword, UsersService usersService){

        String msg = "";
        if (email == null)
            msg = "Missing email field";
        else if (textPassword == null)
            msg = "Missing Password field";
        else {
            Users users = usersService.findUsersByEmail(email);
            if(users == null){
                msg = "Email not found";
            }else{
                System.out.println("textPassword: "+textPassword);
                System.out.println("db password: "+users.getPassword());
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
                if (passwordEncoder.matches(textPassword, users.getPassword())) {
                    System.out.println("It matches");
                    msg = "";
                }else {
                    System.out.println("It does not match");
                    msg = "Incorrect Password entered";
                }
            }
        }
        return msg;
    }

}
