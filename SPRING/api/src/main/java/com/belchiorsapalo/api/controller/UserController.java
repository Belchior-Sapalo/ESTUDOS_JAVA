package com.belchiorsapalo.api.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.belchiorsapalo.api.domain.dto.UserDTO;
import com.belchiorsapalo.api.services.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private UserService service;
    private ModelMapper mapper;
    private static final String ID = "/{id}";

    @Autowired
    public UserController(UserService service, ModelMapper mapper){
        this.service = service;
        this.mapper = mapper;
    }
    
    @GetMapping(ID)
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(mapper.map(service.findById(id), UserDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        return ResponseEntity.ok().body(service.findAll().stream().map(user -> mapper.map(user, UserDTO.class)).toList());
    }

    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO dto){
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path(ID).buildAndExpand(service.create(dto).getId()).toUri()).build();
    }

    @PutMapping(ID)
    public ResponseEntity<UserDTO> update(@PathVariable Integer id, @RequestBody UserDTO dto){
        dto.setId(id);
        return ResponseEntity.ok().body(mapper.map(service.update(dto), UserDTO.class));
    }

    @DeleteMapping(ID)
    public ResponseEntity<UserDTO> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
