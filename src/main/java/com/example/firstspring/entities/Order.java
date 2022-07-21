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
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Instant date;

    private Integer orderStatus;

    //neste caso o cascade serve para o payment e o order tem o mesmo ID, ou seja o payment com id 5 está associado à order com ID 5
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;



    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;


    @OneToMany(mappedBy = "id.order")
    private final Set<OrderItem> items = new HashSet<>();


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

    public Integer getId() {
        return id;
    }

    public Double total() {
        double result = 0.0;

        for (OrderItem orderItem : items) {
            result += orderItem.subTotal();
        }
        return result;
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

    public Set<OrderItem> getOrders() {
        return items;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
