package com.prateek.bangre.controller;

import com.prateek.bangre.model.*;
import com.prateek.bangre.run.service.CategoriesService;
import com.prateek.bangre.run.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping
    private ApiResponse<Products> getProducts(@RequestParam int page, @RequestParam(defaultValue = "0") int limit){
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

        List<ProductsJoin> productsDtoList = productsService.getProductsWithCategories().subList(startValue, endValue);

        if (!productsDtoList.isEmpty()){
            return new ApiResponse<Products>(HttpStatus.OK.value(),"Products list fetched successfully.", productsDtoList);
        }else {
            return new ApiResponse<Products>(HttpStatus.OK.value(),"No products found", productsDtoList);
        }
    }

    @GetMapping("/{prodId}")
    private ApiResponse<Products> getProductsById(@PathVariable int prodId){

        ArrayList<Products> productsList = new ArrayList<>();

        productsList.add(productsService.getProductsById(prodId));
        if (!productsList.isEmpty()){
            return new ApiResponse<Products>(HttpStatus.OK.value(),"Products list fetched successfully.", productsList);
        }else {
            return new ApiResponse<Products>(HttpStatus.OK.value(),"No product found with id: "+prodId, productsList);
        }
    }

}
