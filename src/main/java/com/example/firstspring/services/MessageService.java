package com.example.firstspring.services;

import com.example.firstspring.entities.Message;
import com.example.firstspring.repositories.MessageRepository;
import com.example.firstspring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository repository;

    public List<Message> findAll() {
        return repository.findAll();
    }

    public Message findById(int id) {
        Optional<Message> obj = repository.findById(id);
        return obj.get();
    }

}
