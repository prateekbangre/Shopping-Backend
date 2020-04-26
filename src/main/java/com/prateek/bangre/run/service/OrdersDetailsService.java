package com.prateek.bangre.run.service;

import com.prateek.bangre.jpa_repository.OrdersDetailsRepository;
import com.prateek.bangre.model.OrdersDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author prateek.bangre on 26/04/20.
 * @Project Shoping-Backend
 */
@Service
@Transactional
public class OrdersDetailsService {

    @Autowired
    private OrdersDetailsRepository repo;

    public List<OrdersDetails> listAll() {
        return repo.findAll();
    }

    public void save(OrdersDetails product) {
        repo.save(product);
    }

    public OrdersDetails get(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
