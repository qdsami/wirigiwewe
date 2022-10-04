package com.example.project.repos;

import com.example.project.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {
    List<User> findByCity(String city);
}
