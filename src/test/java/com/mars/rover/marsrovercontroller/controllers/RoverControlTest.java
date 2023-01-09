package com.mars.rover.marsrovercontroller.controllers;

import com.mars.rover.marsrovercontroller.services.RoverService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.event.annotation.BeforeTestExecution;

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
}
