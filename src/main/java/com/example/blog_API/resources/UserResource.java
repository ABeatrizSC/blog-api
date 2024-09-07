package com.example.blog_API.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.blog_API.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //define que será um recurso REST
@RequestMapping(value="/users") //endpoint
public class UserResource {

    @RequestMapping(method=RequestMethod.GET) //metodo http deste endpoint
    public ResponseEntity<List<User>> findAll() { //ResponseEntity = encapsula toda a estrutura necessária para uma resposta http (cabecalhos...)
        User maria = new User("1", "Maria Brown", "maria@gmail.com");
        User alex = new User("2", "Alex Green", "alex@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(list);
    }
}