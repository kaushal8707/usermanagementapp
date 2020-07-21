package com.always.learner.usermanagementapp.service;

import com.always.learner.usermanagementapp.dto.User;

import java.util.List;

public interface UserService
{
    public List<User> getAllUser();

    public User getUser(String id);

    public void addUser(User user);

    public User updateUser(User user);

    public User deleteUser(String id);
}
