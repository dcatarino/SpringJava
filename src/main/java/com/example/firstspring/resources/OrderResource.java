package com.example.firstspring.resources;


import com.example.firstspring.entities.Order;
import com.example.firstspring.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService service;

    // getmapping para reperesentar que isto é um GET http
    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable int id) {
        Order Order = service.findById(id);
        return ResponseEntity.ok().body(Order);
    }
    @GetMapping(value = "/client")
    public ResponseEntity<List<Order>> findByClientID() {
        List<Order> list = service.findByClientId();
        return ResponseEntity.ok().body(list);
    }
}
