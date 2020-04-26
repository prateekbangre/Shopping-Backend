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
@Table(name = "ordersDetails")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrdersDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int order_id;
    @Column
    private int product_id;
    @Column
    private int quantity;
}
