package com.example.firstspring.entities;

import com.example.firstspring.enums.OrderStatus;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "app_order")
public class Order implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Instant date;

    private Integer orderStatus;


    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;


    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();


    public Order() {

    }

    public Order(Instant date, User client, OrderStatus status) {
        super();
        this.date = date;
        this.client = client;
        this.orderStatus = status.getCode();
    }




    public Order(int id, Instant date, User client, OrderStatus status) {
        super();
        this.id = id;
        this.date = date;
        this.client = client;
        this.orderStatus = status.getCode();
    }

    public int getId() {
        return id;
    }


    public OrderStatus getorderStatus() {
        return OrderStatus.valeuOf(orderStatus);
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public User getclient() {
        return client;
    }

    public void setclient(User client) {
        this.client = client;
    }

    public Set<OrderItem> getItems() {
        return items;
    }
}
