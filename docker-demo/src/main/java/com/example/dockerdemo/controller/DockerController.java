package com.example.dockerdemo.controller;

import com.example.dockerdemo.common.UpdateTool;
import com.example.dockerdemo.exception.TestException;
import com.example.dockerdemo.repository.UserRepository;
import com.example.dockerdemo.model.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

/**
 * @author yunN
 * @date 2021/10/27
 */
@RestController
@RequestMapping("/DockerController")
@AllArgsConstructor
public class DockerController {

    private final UserRepository userRepository;

    @GetMapping
    public String hello() {
        return "Hello docker~";
    }

    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/exception/{id}")
    public Integer getException(@PathVariable Integer id) {
        if (id == 1) {
            throw new TestException(9001, "test exception msg");
        } else {
            int a = 1 / 0;
        }
        return 1;
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }

    @PostMapping("/batch")
    public List<User> addUser(@RequestBody List<User> users) {
        userRepository.saveAll(users);
        return users;
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        if (user.getId() != 0) {
            User userSource = userRepository.findById(user.getId());
            UpdateTool.copyNullProperties(userSource, user);
        }
        userRepository.save(user);
        return user;
    }

    @GetMapping("{address}/address")
    public User getByAddress(@PathVariable String address) {
        return userRepository.findByAddress(address);
    }

    @GetMapping("{id}/id")
    public User getById(@PathVariable Integer id) {
        return userRepository.findById(id).orElse(new User());
    }

    @GetMapping("/between")
    public User getByBetween(@RequestParam int id, @RequestParam String name) {
        User byIdAndName = userRepository.findByIdAndName(id, name);
        return byIdAndName;
    }
}
