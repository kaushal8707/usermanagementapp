package com.always.learner.usermanagementapp.controller;
import com.always.learner.usermanagementapp.dto.User;
import com.always.learner.usermanagementapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
public class UserController
{
    Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUser()
    {
        logger.info("access all user");
       return userService.getAllUser();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable  String id)
    {
        logger.info("access user based on id");
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public ResponseEntity<Object> addUser(@RequestBody User user)
    {
        userService.addUser(user);
        URI path=ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(path).build();
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user)
    {
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public User deleteUser(@PathVariable String id)
    {
        return userService.deleteUser(id);
    }


    @GetMapping("/logs")
    public String logs()
    {
        logger.trace("A TRACE MESSAGE");
        logger.info("An INFO Message");
        logger.debug("A DEBUG Message");
        logger.error("An ERROR Message");
        logger.warn("A WARN Message");
        return "Hey buddy see the console for different level of logs";
    }
}
