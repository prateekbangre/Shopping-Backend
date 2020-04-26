package com.prateek.bangre.jpa_repository;


import com.prateek.bangre.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author prateek.bangre on 26/04/20.
 * @Project Shoping-Backend
 */
public interface ProductsRepository extends CrudRepository<Products, Integer> {
    List<Products> findAllBycatId(int cat_id);
}
