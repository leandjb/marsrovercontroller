package com.mars.rover.marsrovercontroller.controllers;

import com.mars.rover.marsrovercontroller.services.RoverService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.event.annotation.BeforeTestExecution;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RoverControlTest {

    @Mock
    RoverService service;

    @InjectMocks
    private RoverControl controller;

    @BeforeTestExecution
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void enviarComandoTest() {

        controller.enviarComandos(null,"ADAA");
        verify(service).ejecutarComando("ADAA");
    }

    @Test
    public void enviarComandoNoPuedeSerNullTest() {

        assertThrows(IllegalArgumentException.class, () ->{

            controller.enviarComandos(null,null);
            verify(service, never()).ejecutarComando(any());

        });

    }
}
