package com.educandoweb.course.services;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User findById(long id) {
        Optional<User> obj = userRepository.findById(id);

        return obj.get();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User insert(User obj) {
        return userRepository.save(obj);
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }

    public User update(long id, User obj) {
        User user = userRepository.getReferenceById(id);
        obj.setName(user.getName());
        obj.setEmail(user.getEmail());
        obj.setPhone(user.getPhone());
        return userRepository.save(user);
    }
}
