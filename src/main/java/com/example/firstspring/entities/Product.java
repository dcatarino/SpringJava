package com.example.firstspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.*;

@Entity
public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    private double price;


    //o many to many no spring cria uma tabela à parte, para nao poluir as tabelas principais, faz sentido
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "tb_category_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

   // @JsonIgnore
    @OneToMany(mappedBy = "id.product") // id vem da classe orderitem e .product vem o product que tem na classe order item
    private Set<OrderItem> items = new HashSet<>();



    public Product() {

    }

    public Product(String name, String description, double price, List<Category> categoryList) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.categories = new HashSet<>(categoryList);

    }

    @JsonIgnore
    public Set<Order> getOrders () {
        Set<Order> orders = new HashSet<>();

        for (OrderItem orderItem : items) {
            orders.add(orderItem.getOrder());
        }
        return orders;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Double.compare(product.price, price) == 0 && Objects.equals(name, product.name) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price);
    }

}
