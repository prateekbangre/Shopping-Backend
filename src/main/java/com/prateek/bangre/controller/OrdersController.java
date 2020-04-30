package com.prateek.bangre.controller;

import com.prateek.bangre.model.ApiResponse;
import com.prateek.bangre.model.NewOrderDto;
import com.prateek.bangre.model.Orders;
import com.prateek.bangre.model.OrdersDetailsJoin;
import com.prateek.bangre.run.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author prateek.bangre on 29/04/20.
 * @Project Shoping-Backend
 */
@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @GetMapping
    public ApiResponse<Orders> getAllOrders(){

        List<OrdersDetailsJoin> allOrders = ordersService.getAllOrders();

        if (!allOrders.isEmpty()){
            return new ApiResponse<>(HttpStatus.OK.value(), "Orders list fetched successfully.", allOrders);
        }else {
            return new ApiResponse<>(HttpStatus.OK.value(), "No orders found", "");
        }
    }

    @GetMapping("/{orderId}")
    public ApiResponse<Orders> getOrdersById(@PathVariable int orderId){

        List<OrdersDetailsJoin> orders = ordersService.getOrdersDetailsById(orderId);

        if (orders.isEmpty()){
            return new ApiResponse<>(HttpStatus.OK.value(), "Order fetched successfully.", orders);
        }else {
            return new ApiResponse<>(HttpStatus.OK.value(), "No orders found on id: "+orderId, "");
        }
    }

    @PostMapping("/new")
    public ApiResponse<OrdersDetailsJoin> placeNewOrder(@RequestBody NewOrderDto newOrderDto){

//        int id = ordersService.updateOrders(Orders.builder().user_id(newOrderDto.getUserId()).build());

        return new ApiResponse<>(HttpStatus.OK.value(), "in-progress", "");
    }

    @PostMapping("/payment")
    public ApiResponse<OrdersDetailsJoin> makingPayment(){


        return new ApiResponse<>(HttpStatus.OK.value(), "in-progress", "");
    }

}
