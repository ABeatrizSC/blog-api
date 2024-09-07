package com.example.blog_API.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.blog_API.domain.User;
import com.example.blog_API.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //define que será um recurso REST
@RequestMapping(value="/users") //endpoint
public class UserResource {

    @Autowired //conexao com o service
    private UserService service;

    @RequestMapping(method=RequestMethod.GET) //metodo http deste endpoint
    public ResponseEntity<List<User>> findAll() { //ResponseEntity = encapsula toda a estrutura necessária para uma resposta http (cabecalhos...)
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}