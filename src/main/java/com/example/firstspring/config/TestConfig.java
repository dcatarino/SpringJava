package com.example.firstspring.config;

import com.example.firstspring.entities.User;
import com.example.firstspring.entities.Message;
import com.example.firstspring.repositories.MessageRepository;
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
    private MessageRepository messageRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User("user1");
        User u2 = new User("user2");

        userRepository.saveAll(Arrays.asList(u1, u2));


        Message m1 = new Message("ola eu sou x", Instant.now(), u1);

        messageRepository.saveAll(List.of(m1));
    }
}
