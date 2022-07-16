package com.example.firstspring.repositories;
import com.example.firstspring.entities.OrderItem;
import com.example.firstspring.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
