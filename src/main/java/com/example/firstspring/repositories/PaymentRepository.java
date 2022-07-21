package com.example.firstspring.repositories;

import com.example.firstspring.entities.Payment;
import com.example.firstspring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
