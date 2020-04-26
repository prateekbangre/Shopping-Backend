package com.prateek.bangre.run.service;

import com.prateek.bangre.jpa_repository.ProductsRepository;
import com.prateek.bangre.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author prateek.bangre on 26/04/20.
 * @Project Shoping-Backend
 */
@Service
@Transactional
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public List<Products> findAll() {
        List<Products> list = new ArrayList<>();
        productsRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public void update(Products product) {
        productsRepository.save(product);
    }

    public Products getById(int id) {
        return productsRepository.findById(id).get();
    }

    public List<Products> getByCategoriesId(int id) {
        return productsRepository.findAllBycatId(id);
    }

    public void delete(int id) {
        productsRepository.deleteById(id);
    }

}
