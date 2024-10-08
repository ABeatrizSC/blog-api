package com.example.blog_API.service;

import com.example.blog_API.domain.User;
import com.example.blog_API.dto.UserDTO;
import com.example.blog_API.repository.UserRepository;
import com.example.blog_API.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired //conexão com repository
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj) {
        return repository.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User update(User updatedData) {
        User user = findById(updatedData.getId());
        updateData(user, updatedData);
        return repository.save(user);
    }

    private void updateData(User user, User updatedData) {
        user.setName(updatedData.getName());
        user.setEmail(updatedData.getEmail());
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
