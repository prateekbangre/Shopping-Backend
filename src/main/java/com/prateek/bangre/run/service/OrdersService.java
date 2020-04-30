package com.prateek.bangre.run.service;

import com.prateek.bangre.jpa_repository.OrdersRepository;
import com.prateek.bangre.model.Orders;
import com.prateek.bangre.model.OrdersDetailsJoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author prateek.bangre on 26/04/20.
 * @Project Shoping-Backend
 */
@Service
@Transactional
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    public List<Orders> findAllOrders() {
        List<Orders> list = new ArrayList<>();
        ordersRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public void updateOrders(Orders order) {
        ordersRepository.save(order);
    }

    public Orders getOrdersById(int id) {
        Optional<Orders> optionalUser = ordersRepository.findById(id);
        return optionalUser.isPresent() ? optionalUser.get() : null;
    }

    public void deleteOrdersById(int id) {
        ordersRepository.deleteById(id);
    }

    public List<OrdersDetailsJoin> getAllOrders() {
        return ordersRepository.getAllOrdersDetails();
    }

    public List<OrdersDetailsJoin> getOrdersDetailsById(int orderId) {
        return ordersRepository.getOrdersDetailsById(orderId);
    }
}
