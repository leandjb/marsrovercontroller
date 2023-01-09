package com.mars.rover.marsrovercontroller.controllers;

import com.mars.rover.marsrovercontroller.services.RoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class RoverControl {

    private RoverService service;

    @Autowired
    public void RoverController(RoverService service){
        this.service = service;
    }

    @RequestMapping("/{comando}")
    public void enviarComandos(@RequestHeader HttpHeaders headers, @PathVariable String comando){

        if (comando == null) {
            throw new IllegalArgumentException("El comando no puede ser null");
        }
        service.ejecutarComando(comando);
    }
}
