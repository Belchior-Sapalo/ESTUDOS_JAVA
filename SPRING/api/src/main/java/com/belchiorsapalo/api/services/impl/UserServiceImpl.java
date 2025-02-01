package com.belchiorsapalo.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belchiorsapalo.api.domain.User;
import com.belchiorsapalo.api.domain.dto.UserDTO;
import com.belchiorsapalo.api.repositories.UserRepository;
import com.belchiorsapalo.api.services.UserService;
import com.belchiorsapalo.api.services.exceptions.DataIntegratyViolationException;
import com.belchiorsapalo.api.services.exceptions.ObjectNotFoundException;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository repository;
    private ModelMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository repository, ModelMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public User findById(Integer id) {
       return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
    }

    @Override
    public List<User> findAll() {
       return repository.findAll();
    }

    @Override
    public User create(UserDTO dto) {
        findByEmail(dto);
        return repository.save(mapper.map(dto, User.class));
    }

    @Override
    public User update(UserDTO dto) {
        findByEmail(dto);
        return repository.save(mapper.map(dto, User.class));
    }

    private void findByEmail(UserDTO dto){
        Optional<User> user = repository.findByEmail(dto.getEmail());
        if (user.isPresent() && !user.get().getId().equals(dto.getId()))
            throw new DataIntegratyViolationException("Este email já existe, tente outro");
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
