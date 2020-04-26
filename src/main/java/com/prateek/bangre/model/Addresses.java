package com.prateek.bangre.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author prateek.bangre on 26/04/20.
 * @Project Shoping-Backend
 */
@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Addresses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String line1;
    @Column
    private String line2;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String country;
    @Column
    private String phone;
    @Column
    private int pincode;
    @Column
    private int user_id;
}
