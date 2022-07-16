package com.example.firstspring.repositories;

import com.example.firstspring.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//tipo da entidade e tipo da key no JpaRepoitory<>

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
