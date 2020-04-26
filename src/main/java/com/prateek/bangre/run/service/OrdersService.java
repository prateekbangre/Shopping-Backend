package com.prateek.bangre.run.service;

import com.prateek.bangre.jpa_repository.OrdersRepository;
import com.prateek.bangre.model.Orders;
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
public class OrdersService {

    @Autowired
    private OrdersRepository repo;

    public List<Orders> listAll() {
        return repo.findAll();
    }

    public void save(Orders product) {
        repo.save(product);
    }

    public Orders get(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
