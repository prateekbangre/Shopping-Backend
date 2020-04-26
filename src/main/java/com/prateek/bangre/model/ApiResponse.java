package com.prateek.bangre.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author prateek.bangre on 26/04/20.
 * @Project Shoping-Backend
 */
@Getter
@Setter
@AllArgsConstructor
public class ApiResponse<T> {

    private int status;
    private String message;
    private Object result;
}
