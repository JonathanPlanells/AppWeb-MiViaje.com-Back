package com.back.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.modelo.Hotel;
import com.back.servicios.HotelService;

@RestController
@RequestMapping("/hoteles")
public class HotelController {

    private HotelService service;

    // CONSTRUCTOR
    public HotelController(){
        service = new HotelService();
    }

    // :::: DECORADOR - CREAR HOTEL :::: //
    @PostMapping
    public String create(@RequestBody Hotel hotel){
        return service.create(hotel);
    }


    // :::: DECORADOR - OBTENIENDO TODOS LOS DATOS ::::
    @GetMapping
    public List<Hotel> getHoteles(){
        List<Hotel> hoteles = service.getHoteles();
        return hoteles;
    }

    
}
