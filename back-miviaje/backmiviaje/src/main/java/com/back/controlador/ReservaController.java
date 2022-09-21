package com.back.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    // ::::  OBTENIENDO TODOS LOS DATOS ::::
    @GetMapping
    public List<Reserva> getReservas(){
        List<Reserva> reservas = service.getReservas();
        return reservas;
    }
    
    // ::::  OBTENIENDO HOTEL POR ID ::::
    @GetMapping("/id/{id}")
    public Reserva getReservaId(@PathVariable(name="id") int idReservas){
        return service.getReservaId(idReservas);
    }
    
    // ::::  OBTENIENDO RESERVA POR NUM DOCUMENTO - TOKEN ::::

    @GetMapping("/tu-reserva")
    public Reserva getReservaNumDocumentoToken(@RequestParam String numeroDocumento, @RequestParam String token){
        return service.getReservaNumDocumentoToken(numeroDocumento, token);
    }

    // ::::  OBTENIENDO TOKEN POR ID ::::
    @GetMapping("/token/{numerodocumento}")
    public List<Reserva> getID_TOKEN(@PathVariable(name="numerodocumento") String numeroDocumento){
        return service.getID_TOKEN(numeroDocumento);
    }

    // :::: BORRAR - RESERVA :::: //
    @DeleteMapping("/{id}")
    public String borrarReserva(@PathVariable(name="id") int idReservas){
        return service.borrarReserva(idReservas);
    }
    
    @PutMapping
    public String actualizarReserva(@RequestBody Reserva reserva){
        return service.actualizarReserva(reserva);
    }
    
}
