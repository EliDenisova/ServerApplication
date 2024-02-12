package com.example.serverApplication.controllers;

import com.example.serverApplication.domain.User;
import com.example.serverApplication.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private DataProcessingService service;

    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge() {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }


    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(List<User> users, @PathVariable int age) {
        return service.filterUsersByAge(users, age);
    }


    @GetMapping("/calc")
    public double calculateAverageAge(List<User> users){
        return  service.calculateAverageAge(users);
    }
}
