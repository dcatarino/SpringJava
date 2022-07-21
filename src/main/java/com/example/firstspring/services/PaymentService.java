package com.example.firstspring.services;


import com.example.firstspring.entities.Payment;
import com.example.firstspring.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public List<Payment> findAll() {
        return repository.findAll();
    }

    public Payment findById(int id) {
        Optional<Payment> obj = repository.findById(id);
        return obj.get();
    }

}
