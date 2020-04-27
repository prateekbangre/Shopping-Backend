package com.prateek.bangre.jpa_repository;


import com.prateek.bangre.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * @author prateek.bangre on 26/04/20.
 * @Project Shoping-Backend
 */
public interface OrdersRepository extends CrudRepository<Orders, Integer> {
}
