package com.example.firstspring.resources;



import com.example.firstspring.entities.Product;
import com.example.firstspring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResoruce {

    @Autowired
    private ProductService service;

    // getmapping para reperesentar que isto é um GET http
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable int id) {
        Product Order = service.findById(id);
        return ResponseEntity.ok().body(Order);
    }
}
