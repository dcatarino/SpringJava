package com.example.firstspring.resources;


import com.example.firstspring.entities.Message;
import com.example.firstspring.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/messages")
public class MessageResource {

    @Autowired
    private MessageService service;

    // getmapping para reperesentar que isto é um GET http
    @GetMapping
    public ResponseEntity<List<Message>> findAll() {
        List<Message> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Message> findById(@PathVariable int id) {
        Message Message = service.findById(id);
        return ResponseEntity.ok().body(Message);
    }
}
