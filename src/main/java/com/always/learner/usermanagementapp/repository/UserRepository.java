package com.always.learner.usermanagementapp.repository;

import com.always.learner.usermanagementapp.dto.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository
{
    List<User> userList=new ArrayList<User>();

    public List<User> getAllUser() {
        return userList;
    }

    public User getUser(String id)
    {
        Optional<User> first=userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
        if(first.isPresent())
        {
            return first.get();
        }
        return new User();
    }

    public void addUser(User user)
    {
        userList.add(user);
    }

    public User updateUser(User user) {
        for(User usr : userList)
        {
            if(usr.getId().equals(user.getId()))
            {
                usr.setName(user.getName());
                usr.setAddress(user.getAddress());
                return usr;
            }
        }
        return new User();
    }

    public User deleteUser(String id) {
        Optional<User> first=userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
        if(first.isPresent())
        {
            User user=first.get();
            userList.remove(user);
            return user;
        }
        return new User();
    }
}
