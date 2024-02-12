package com.example.serverApplication.repository;

import com.example.serverApplication.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbc;
    private List<User> users = new ArrayList<>();

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User save(User user){
        String sql = "INSERT INTO users (userAge, userName, email) VALUES (?,?,?)";
        jdbc.update(sql,user.getAge(), user.getName(),user.getEmail());
        return user;
    }
}