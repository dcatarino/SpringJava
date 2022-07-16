package com.example.firstspring.repositories;

import com.example.firstspring.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//tipo da entidade e tipo da key no JpaRepoitory<>

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("SELECT o from Order o WHERE o.client.userId = 1")
    List<Order> findByClientID();

}
