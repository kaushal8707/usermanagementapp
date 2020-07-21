package com.always.learner.usermanagementapp.service;
import com.always.learner.usermanagementapp.dto.User;
import com.always.learner.usermanagementapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public User getUser(String id) {
       return userRepository.getUser(id);
    }

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.updateUser(user);
    }

    @Override
    public User deleteUser(String id) {
        return userRepository.deleteUser(id);
    }
}
