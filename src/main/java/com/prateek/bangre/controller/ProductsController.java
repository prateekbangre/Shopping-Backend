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
    ProductsService productsService;

    @GetMapping
    private ApiResponse<ProductsJoin> getProducts(@RequestParam int page, @RequestParam(defaultValue = "0") int limit){
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
            return new ApiResponse<>(HttpStatus.OK.value(),"Products list fetched successfully.", productsDtoList);
        }else {
            return new ApiResponse<>(HttpStatus.OK.value(),"No products found", productsDtoList);
        }
    }

    @GetMapping("/{prodId}")
    private ApiResponse<ProductsJoin> getProductsById(@PathVariable int prodId){

        List<ProductsJoin> productsDtoListByID = productsService.getProductsWithCategoriesById(prodId);
        if (productsDtoListByID != null){
            return new ApiResponse<>(HttpStatus.OK.value(),"Products fetched successfully.", productsDtoListByID);
        }else {
            return new ApiResponse<>(HttpStatus.OK.value(),"No product found with id: "+prodId, productsDtoListByID);
        }
    }

    @GetMapping("/category/{categoryName}")
    private ApiResponse<ProductsJoin> getProductsByCategoryNameAndPage(@PathVariable String categoryName, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "0") int limit){

        page = page== 0 ? page : 1;   // check if page query param is defined or not
        limit = limit== 0 ? limit : 10;   // set limit of items per page
        int startValue;
        int endValue;
        if (page > 0) {
            startValue = (page * limit) - limit;      // 0, 10, 20, 30
            endValue = page * limit;                  // 10, 20, 30, 40
        } else {
            startValue = 0;
            endValue = 10;
        }

        List<ProductsJoin> productsDtoListByCategoryName = productsService.getProductsWithCategoriesByCategoryName(categoryName).subList(startValue, endValue);
        if (productsDtoListByCategoryName != null){
            return new ApiResponse<>(HttpStatus.OK.value(),"Products fetched successfully.", productsDtoListByCategoryName);
        }else {
            return new ApiResponse<>(HttpStatus.OK.value(),"No products found matching the category: "+categoryName, productsDtoListByCategoryName);
        }
    }

}
