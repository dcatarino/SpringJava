package com.example.firstspring.config;

import com.example.firstspring.entities.Category;
import com.example.firstspring.entities.Product;
import com.example.firstspring.entities.User;
import com.example.firstspring.entities.Order;
import com.example.firstspring.enums.OrderStatus;
import com.example.firstspring.repositories.OrderRepository;
import com.example.firstspring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;


//configuraçao do perfil teste
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    //injects object dependacy
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User("user1");
        User u2 = new User("user2");

        userRepository.saveAll(Arrays.asList(u1, u2));

        Order o1 = new Order(Instant.now(), u1, OrderStatus.PAID);

        Order o2 = new Order(Instant.now(), u1, OrderStatus.PAID);

        Order o3 = new Order(Instant.now(), u2, OrderStatus.SHIPPED);

        Order o4 = new Order(4, Instant.now(), u2, OrderStatus.SHIPPED);

/*        Category c1 = new Category("Eletronics");
        Category c2 = new Category("Books");
        Category c3 = new Category("Movies");



        Product p1 = new Product("The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product("Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product("Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product("PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product( "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");


        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());*/




        orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));
    }
}
