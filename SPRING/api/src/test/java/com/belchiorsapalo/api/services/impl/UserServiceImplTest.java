package com.belchiorsapalo.api.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.belchiorsapalo.api.domain.User;
import com.belchiorsapalo.api.domain.dto.UserDTO;
import com.belchiorsapalo.api.repositories.UserRepository;
import com.belchiorsapalo.api.services.exceptions.DataIntegratyViolationException;
import com.belchiorsapalo.api.services.exceptions.ObjectNotFoundException;

@SpringBootTest
public class UserServiceImplTest {

    private static final String ESTE_EMAIL_JA_EXISTE_TENTE_OUTRO = "Este email já existe, tente outro";

    private static final int INDEX = 0;

    private static final String USUARIO_NAO_ENCONTRADO = "Usuário não encontrado";

    private static final String PASSWORD = "1224";

    private static final String EMAIL = "bel@gmail.com";

    private static final String NAME = "Belchior";

    private static final Integer ID = 1;

    @Mock
    private UserRepository repository;

    @Mock
    private ModelMapper mapper;

    @InjectMocks
    private UserServiceImpl service;

    private User user;

    private UserDTO dto;

    private Optional<User> optionalUser;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void whenCreateThenReturnsSuccess() {
        when(repository.save(any())).thenReturn(user);

        User response = service.create(dto);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(PASSWORD, response.getPassword());
        
    }

    @Test
    void whenCreateThenThrowDataIntegrityViolationException() {
        when(repository.findByEmail(anyString())).thenReturn(optionalUser);

        try {
            optionalUser.get().setId(2);
            service.create(dto);
        } catch (Exception ex) {
            assertEquals(DataIntegratyViolationException.class, ex.getClass());
            assertEquals(ESTE_EMAIL_JA_EXISTE_TENTE_OUTRO, ex.getMessage());
        }
        
    }

    @Test
    void whenDeleteTheReturnsSuccess() {
        when(repository.findById(anyInt())).thenReturn(optionalUser);
        doNothing().when(repository).deleteById(anyInt());
        service.delete(ID);
        verify(repository, times(1)).deleteById(anyInt());
    }

    @Test
    void whenDeleteTheThrowObjectNotFoundException() {
        when(repository.findById(anyInt())).thenThrow(new ObjectNotFoundException(USUARIO_NAO_ENCONTRADO));
        try {
            service.delete(ID);
        } catch (Exception ex) {
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals(USUARIO_NAO_ENCONTRADO, ex.getMessage());
        }
    }

    @Test
    void whenFindAllThenReturnsAListOfUsers() {
        when(repository.findAll()).thenReturn(List.of(user));

        List<User> response = service.findAll();
        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(User.class, response.get(INDEX).getClass());
        assertEquals(ID, response.get(INDEX).getId());
        assertEquals(NAME, response.get(INDEX).getName());
        assertEquals(EMAIL, response.get(INDEX).getEmail());
        assertEquals(PASSWORD, response.get(INDEX).getPassword());

    }

    @Test
    void whenFindByIdThenReturnsAnUserInstance() {
        when(repository.findById(anyInt())).thenReturn(optionalUser);

        User response = service.findById(ID);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
    }

    @Test
    void whenFindByIdThenThrowObjectNotFoundException() {
       when(repository.findById(anyInt())).thenThrow(new ObjectNotFoundException(USUARIO_NAO_ENCONTRADO));

       try {
        service.findById(ID);
       } catch (Exception ex) {
        assertEquals(ObjectNotFoundException.class, ex.getClass());
        assertEquals(USUARIO_NAO_ENCONTRADO, ex.getMessage());
       }
    }

    @Test
    void whenUpdateThenReturnsSuccess() {
        when(repository.save(any())).thenReturn(user);

        User response = service.update(dto);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(PASSWORD, response.getPassword());
        
    }

    @Test
    void whenUpdateThenThrowDataIntegrityViolationException() {
        when(repository.findByEmail(anyString())).thenReturn(optionalUser);

        try {
            optionalUser.get().setId(2);
            service.create(dto);
        } catch (Exception ex) {
            assertEquals(DataIntegratyViolationException.class, ex.getClass());
            assertEquals(ESTE_EMAIL_JA_EXISTE_TENTE_OUTRO, ex.getMessage());
        }
        
    }


    private void startUser(){
        user = new User(ID, NAME, EMAIL, PASSWORD);
        dto = new UserDTO(ID, NAME, EMAIL, PASSWORD);
        optionalUser = Optional.of(new User(ID, NAME, EMAIL, PASSWORD));
    }
}
