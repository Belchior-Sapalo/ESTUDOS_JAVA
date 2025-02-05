package com.belchiorsapalo.api.controller.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import com.belchiorsapalo.api.services.exceptions.DataIntegratyViolationException;
import com.belchiorsapalo.api.services.exceptions.ObjectNotFoundException;


@SpringBootTest
public class ControllerExceptionHandlerTest {


    private static final String ESTE_OBJECTO_JA_EXISTE = "Este objecto já existe";
    private static final String OBJECTO_NAO_ENCONTRADO = "Objecto não encontrado";
    @InjectMocks
    private ControllerExceptionHandler cExceptionHandler;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenIntegrityViolationExceptionThenReturnAResponseEntity() {
        ResponseEntity<StandardError> response = cExceptionHandler.integratyViolationExceptionHandler(new DataIntegratyViolationException(ESTE_OBJECTO_JA_EXISTE), new MockHttpServletRequest());

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(StandardError.class, response.getBody().getClass());
        assertEquals(400, response.getBody().getStatus());
        assertEquals(ESTE_OBJECTO_JA_EXISTE, response.getBody().getError());

    }

    @Test
    void whenObjectNotFoundExceptionThenReturnAResponseEntity() {
        ResponseEntity<StandardError> response = cExceptionHandler.objectNotFoundExceptionHandler(new ObjectNotFoundException(OBJECTO_NAO_ENCONTRADO), new MockHttpServletRequest());

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(StandardError.class, response.getBody().getClass());
        assertEquals(404, response.getBody().getStatus());
        assertEquals(OBJECTO_NAO_ENCONTRADO, response.getBody().getError());
    }
}
