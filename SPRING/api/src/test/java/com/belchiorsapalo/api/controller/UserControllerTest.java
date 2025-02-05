package com.belchiorsapalo.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.belchiorsapalo.api.domain.User;
import com.belchiorsapalo.api.domain.dto.UserDTO;
import com.belchiorsapalo.api.services.impl.UserServiceImpl;

@SpringBootTest
public class UserControllerTest {

    private static final String NAME = "Belchior";
    private static final String EMAIL = "bel@gmail.com";
    private static final String PASSWORD = "1224";
    private static final Integer ID = 1;
    private static final Integer INDEX = 0;

    private User user;
    private UserDTO dto;
    private Optional<User> optionalUser;

    @Mock
    private UserServiceImpl service;

    @Mock
    private ModelMapper mapper;

    @InjectMocks
    private UserController controller;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void whenDeleteThenRetunSuccess() {
        doNothing().when(service).delete(anyInt());

        ResponseEntity<UserDTO> response = controller.delete(ID);

        assertNotNull(response);
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(service).delete(anyInt());
    }

    @Test
    void whenFindAllThenReturnAnUserDtoList() {
        when(mapper.map(any(), any())).thenReturn(dto);
        when(service.findAll()).thenReturn(List.of(user));

        ResponseEntity<List<UserDTO>> response = controller.findAll();
        
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(UserDTO.class, response.getBody().get(INDEX).getClass());
        assertEquals(ID, response.getBody().get(INDEX).getId());
        assertEquals(EMAIL, response.getBody().get(INDEX).getEmail());
        assertEquals(NAME, response.getBody().get(INDEX).getName());
        assertEquals(PASSWORD, response.getBody().get(INDEX).getPassword());

    }

    @Test
    void whenFindByIdThenReturnSuccess() {
        when(service.findById(anyInt())).thenReturn(user);
        when(mapper.map(any(), any())).thenReturn(dto);

        ResponseEntity<UserDTO> response = controller.findById(anyInt());

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(UserDTO.class, response.getBody().getClass());
        assertEquals(ID, response.getBody().getId());
        assertEquals(EMAIL, response.getBody().getEmail());
        assertEquals(NAME, response.getBody().getName());
        assertEquals(PASSWORD, response.getBody().getPassword());
    }

    @Test
    void whenCreateThenReturnSuccess() {
        when(service.create(any())).thenReturn(user);

        ResponseEntity<UserDTO> response = controller.save(dto);
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getHeaders().get("Location"));
    }

    @Test
    void whenUpdateThenReturnSuccess() {
        when(service.update(dto)).thenReturn(user);
        when(mapper.map(any(), any())).thenReturn(dto);

        ResponseEntity<UserDTO> response = controller.update(ID, dto);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(UserDTO.class, response.getBody().getClass());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ID, response.getBody().getId());
        assertEquals(EMAIL, response.getBody().getEmail());
        assertEquals(NAME, response.getBody().getName());
        assertEquals(PASSWORD, response.getBody().getPassword());
    }

    private void startUser(){
        user = new User(ID, NAME, EMAIL, PASSWORD);
        dto = new UserDTO(ID, NAME, EMAIL, PASSWORD);
        optionalUser = Optional.of(new User(ID, NAME, EMAIL, PASSWORD));
    }
}
