package com.prateek.bangre.controller;

import com.prateek.bangre.model.ApiResponse;
import com.prateek.bangre.model.Categories;
import com.prateek.bangre.model.Products;
import com.prateek.bangre.model.Users;
import com.prateek.bangre.run.service.CategoriesService;
import com.prateek.bangre.run.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author prateek.bangre on 26/04/20.
 * @Project Shoping-Backend
 */
@RestController
@RequestMapping("/api/products")
public class ProductsController  {

    @Autowired
    CategoriesService categoriesService;

    @Autowired
    ProductsService productsService;

    @GetMapping("/page/{page}/limit/{limit}")
    private ApiResponse<Products> getProducts(@PathVariable int page, @PathVariable int limit){
        page = (page == 0 ? 1 : page);
        limit = (limit == 0 ? 10 : limit);   // set limit of items per page
        int startValue;
        int endValue;
        if (page > 0) {
            startValue = (page * limit) - limit;     // 0, 10, 20, 30
            endValue = page * limit;                  // 10, 20, 30, 40
        } else {
            startValue = 0;
            endValue = 10;
        }

        ArrayList<Categories> categoriesList = (ArrayList<Categories>) categoriesService.listAll();
        ArrayList<Products> productsList = new ArrayList<>();
        for (Categories categorie: categoriesList) {
            productsList.addAll(productsService.getByCategoriesId(categorie.getId()));
        }

        return new ApiResponse<Products>(HttpStatus.OK.value(),"Products list fetched successfully.", productsList);
    }
}
