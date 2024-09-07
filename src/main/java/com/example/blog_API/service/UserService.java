package com.example.blog_API.service;

import com.example.blog_API.domain.User;
import com.example.blog_API.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired //conexão com repository
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
}
