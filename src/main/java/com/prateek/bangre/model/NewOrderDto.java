package com.prateek.bangre.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author prateek.bangre on 29/04/20.
 * @Project Shoping-Backend
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewOrderDto extends Products {

    int userId;
}
