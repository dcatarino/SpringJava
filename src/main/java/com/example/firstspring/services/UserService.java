package com.example.firstspring.services;

import com.example.firstspring.entities.User;
import com.example.firstspring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(int id) {
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }

    public User insert(User obj) {
        return repository.save(obj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public User update(Integer id, User object) {
        // getone e getbyid deprecated
        User entity = repository.getReferenceById(id);
        updateData(entity, object);
        return repository.save(entity);

    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
    }
}
