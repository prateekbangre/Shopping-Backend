package com.prateek.bangre.run.service;

import com.prateek.bangre.jpa_repository.ProductsRepository;
import com.prateek.bangre.model.Products;
import com.prateek.bangre.model.ProductsJoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

/**
 * @author prateek.bangre on 26/04/20.
 * @Project Shoping-Backend
 */
@Service
@Transactional
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public List<Products> findAllProducts() {
        List<Products> list = new ArrayList<>();
        productsRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public void updateProducts(Products product) {
        productsRepository.save(product);
    }

    public Products getProductsById(int id) {
        Optional<Products> optionalUser = productsRepository.findById(id);
        return optionalUser.isPresent() ? optionalUser.get() : null;
    }

    public List<Products> getProductsByCategoriesId(int id) {
        return productsRepository.findAllBycatId(id);
    }

    public void deleteProductsById(int id) {
        productsRepository.deleteById(id);
    }

    public List<ProductsJoin> getProductsWithCategories() {
        return productsRepository.getProductsWithCategoriesTitle();
    }
}
