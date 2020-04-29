package com.prateek.bangre.jpa_repository;


import com.prateek.bangre.model.Orders;
import com.prateek.bangre.model.OrdersDetailsJoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author prateek.bangre on 26/04/20.
 * @Project Shoping-Backend
 */
public interface OrdersRepository extends CrudRepository<Orders, Integer> {

    @Query(value = "select o.id, p.title, p.description, p.price, u.username from orders_details as od join orders as o join products as p join users as u where o.id = od.order_id  and p.id = od.product_id and u.id = o.user_id", nativeQuery = true)
    List<OrdersDetailsJoin> getAllOrdersDetails();

    @Query(value = "select o.id, p.title, p.description, p.price, u.username from orders_details as od join orders as o join products as p join users as u where o.id = ?1  and p.id = od.product_id and u.id = o.user_id", nativeQuery = true)
    List<OrdersDetailsJoin> getOrdersDetailsById(int orderId);
}
