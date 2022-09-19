package com.back.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.modelo.Reserva;
import com.back.servicios.ReservaService;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private ReservaService service;

    // CONSTRUCTOR
    public ReservaController(){
        service = new ReservaService();
    }

    // ::::  CREAR RESERVA :::: //
    @PostMapping
    public String crearReserva(@RequestBody Reserva reserva){
        return service.crearReserva(reserva);
    }
    @GetMapping
    public List<Reserva> getReservas(){
        List<Reserva> reservas = service.getReservas();
        return reservas;
    }
    
}
