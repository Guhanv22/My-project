package com.example.audible.controller;

import com.example.audible.Service.OrderService;
import com.example.audible.model.Genre;
import com.example.audible.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrder();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/addOrderDetails")
    public Order postOrderDetails(@RequestBody Order order){

        return orderService.saveOrderDetails(order);
    }
}

