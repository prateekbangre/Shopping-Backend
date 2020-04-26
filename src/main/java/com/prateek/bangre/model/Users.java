package com.prateek.bangre.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.*;

import javax.persistence.*;

/**
 * @author prateek.bangre on 26/04/20.
 * @Project Shoping-Backend
 */
@Entity
@Table(name = "users")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String username;
    @Column
    @JsonIgnore
    private String password;
    @Column
    private String email;
    @Column
    private String fname;
    @Column
    private String lname;
    @Column
    private String age;
    @Column
    private String role;
    @Column
    @JsonIgnore
    private String photo_url;
    @JsonIgnore
    private String type;
}
