package com.prateek.bangre.run.service;

import com.prateek.bangre.jpa_repository.CategoriesRepository;
import com.prateek.bangre.model.Categories;
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
public class CategoriesService {

    @Autowired
    private CategoriesRepository repo;

    public List<Categories> listAll() {
        return repo.findAll();
    }

    public void save(Categories product) {
        repo.save(product);
    }

    public Categories get(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
