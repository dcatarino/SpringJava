package com.example.firstspring.entities;

import com.example.firstspring.entities.pk.OrderItemPK;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serial;
import java.io.Serializable;


@Entity
public class OrderItem implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    @EmbeddedId // isto serve para PK compostos de mais que um elemento
    private OrderItemPK id;

    private Integer quantity;
    private Double price;



    public OrderItem() {

    }

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        super();
        this.quantity = quantity;
        this.price = price;

        id = new OrderItemPK(order, product);
    }


    public OrderItemPK getId() {
        return id;
    }

    public void setId(OrderItemPK id) {
        this.id = id;
    }

    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product order) {
        id.setProduct(order);
    }




    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
