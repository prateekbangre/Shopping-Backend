package com.prateek.bangre.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author prateek.bangre on 28/04/20.
 * @Project Shoping-Backend
 */
@Builder
@Data
@AllArgsConstructor
public class LoginResponse {

    String token;
    boolean auth;
    String email;
    String username;
}
