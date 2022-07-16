package com.example.firstspring.services;

import com.example.firstspring.entities.Order;
import com.example.firstspring.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(int id) {
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }

    public List<Order> findByClientId() {
        return repository.findByClientID();
    }


}
