package com.prateek.bangre.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

/**
 * @author prateek.bangre on 26/04/20.
 * @Project Shoping-Backend
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersRequest {

    private String username;
    private String password;
    private String email;
    private String fname;
    private String lname;
    private int age;
    private int role;
    private String type;
}
