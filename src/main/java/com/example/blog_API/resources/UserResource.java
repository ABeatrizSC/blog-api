package com.example.blog_API.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.blog_API.domain.User;
import com.example.blog_API.dto.UserDTO;
import com.example.blog_API.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController //define que será um recurso REST
@RequestMapping(value="/users") //endpoint
public class UserResource {

    @Autowired //conexao com o service
    private UserService service;

    @RequestMapping(method=RequestMethod.GET) //metodo http deste endpoint
    public ResponseEntity<List<UserDTO>> findAll() { //ResponseEntity = encapsula toda a estrutura necessária para uma resposta http (cabecalhos...)
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(user -> new UserDTO(user)).collect(Collectors.toList()); //converte cada elemento da lista anterior para um DTO
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User userObj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(userObj)); //convertido a UserDTO
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
        User obj = service.fromDTO(objDto); //converte DTO para User
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); //cabeçalho com a URL do novo recurso
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}