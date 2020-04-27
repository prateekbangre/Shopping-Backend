package com.prateek.bangre.run.service;

import com.prateek.bangre.jpa_repository.OrdersDetailsRepository;
import com.prateek.bangre.model.Orders;
import com.prateek.bangre.model.OrdersDetails;
import com.prateek.bangre.model.Users;
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
public class OrdersDetailsService {

    @Autowired
    private OrdersDetailsRepository ordersDetailsRepository;

    public List<OrdersDetails> findAllOrdersDetails() {
        List<OrdersDetails> list = new ArrayList<>();
        ordersDetailsRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public void updateOrdersDetail(OrdersDetails product) {
        ordersDetailsRepository.save(product);
    }

    public OrdersDetails getOrdersDetailsById(int id) {
        Optional<OrdersDetails> optionalUser = ordersDetailsRepository.findById(id);
        return optionalUser.isPresent() ? optionalUser.get() : null;
    }

    public void deleteOrdersDetailsById(int id) {
        ordersDetailsRepository.deleteById(id);
    }
}
