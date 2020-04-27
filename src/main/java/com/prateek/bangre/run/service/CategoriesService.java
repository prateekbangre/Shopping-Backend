package com.prateek.bangre.run.service;

import com.prateek.bangre.jpa_repository.CategoriesRepository;
import com.prateek.bangre.model.Categories;
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
public class CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    public List<Categories> findAllCategories() {
        List<Categories> list = new ArrayList<>();
        categoriesRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public void updateCategories(Categories product) {
        categoriesRepository.save(product);
    }

    public Categories getCategoriesById(int id) {
        Optional<Categories> optionalUser = categoriesRepository.findById(id);
        return optionalUser.isPresent() ? optionalUser.get() : null;
    }

    public void deleteCategoriesById(int id) {
        categoriesRepository.deleteById(id);
    }
}
