package com.back.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public HotelController() {
        service = new HotelService();
    }

    // ::::  CREAR HOTEL :::: //
    @PostMapping
    public String create(@RequestBody Hotel hotel) {
        return service.create(hotel);
    }

    // ::::  OBTENIENDO TODOS LOS DATOS ::::
    @GetMapping
    public List<Hotel> getHoteles() {
        List<Hotel> hoteles = service.getHoteles();
        return hoteles;
    }

    // ::::  OBTENIENDO HOTEL POR ID ::::
    @GetMapping("/id/{id}")
    public Hotel getHotelId(@PathVariable(name = "id") int idHoteles) {
        return service.getHotelId(idHoteles);
    }

    // :::: OBTENIENDO HOTEL POR CIUDAD ::::
    @GetMapping("/{ciudad}")
    public List<Hotel> getHotelCiudad(@PathVariable(name = "ciudad") String ciudad){
        return service.getHotelCiudad(ciudad);
    }

    // :::: ACTUALIZAR - HOTEL :::: //
    @PutMapping
    public String actualizarHotel(@RequestBody Hotel hotel){
        return service.actualizarHotel(hotel);
    }

    // :::: BORRAR - HOTEL :::: //
    @DeleteMapping("/{idHotel}")
    public String borraHotel(@PathVariable(name="idHotel") int idHoteles){
        return service.borrarHotel(idHoteles);
    }
}
