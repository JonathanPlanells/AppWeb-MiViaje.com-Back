package com.back.modelo;

import java.time.LocalDate;

import com.back.servicios.ReservaService;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservas")

public class Reserva {

    
    // ATRIBUTOS
    @Id
    private int idReservas;
    private String token = ReservaService.generarToken(10);
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private int cantidadPersonas;
    private int cantidadHabitaciones;
    private String nombrePersona;
    private String apellidoPersona;
    private String correoPersona;
    private String telefonoPersona;
    private String tipoDocumento;
    private String numeroDocumento;
    private int fkHotel;

    // CONSTRUCTORES 
    public Reserva(){
    }

    public Reserva(String token, LocalDate fechaInicial, LocalDate fechaFinal, int cantidadPersonas, int cantidadHabitaciones, String nombrePersona,
            String apellidoPersona, String correoPersona, String telefonoPersona, String tipoDocumento, String numeroDocumento, int fkHotel) {
        //this.token = service.generateRandomString(10);
        this.token = token;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.cantidadPersonas = cantidadPersonas;
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.correoPersona = correoPersona;
        this.telefonoPersona = telefonoPersona;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.fkHotel = fkHotel;
    }


    public String toString(){
        String info = "----------------------\n";
        info += "token: " + token;
        info += "fechaInicial: " + fechaInicial;
        info += "fechaFinal" + fechaFinal;
        info += "cantidadPersonas" + cantidadPersonas;
        info += "nombrePersona" + nombrePersona;
        info += "apellidoPersona" + apellidoPersona;
        info += "correoPersona" + correoPersona;
        info += "telefonoPersona" + telefonoPersona;
        info += "tipoDocumento" + tipoDocumento;
        info += "numeroDocumento" + numeroDocumento;
        info += "\n----------------------\n";
        return info;
    }

    // CONSULTORES // GETTERS
    public int getIdReservas() {
        return idReservas;
    }

    public String getToken() {
        return token;
    }

    public LocalDate getFechaInicial() {
        return fechaInicial;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }
    public int getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }
    
    public String getNombrePersona() {
        return nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public String getCorreoPersona() {
        return correoPersona;
    }
    
    public String getTelefonoPersona(){
        return telefonoPersona;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }
    
    public int getFkHotel() {
        return fkHotel;
    }

    //MODIFICADORES // SETTERS

    public void setFechaInicial(LocalDate fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }
    public void setCantidadHabitacioness(int cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }
    
    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public void setCorreoPersona(String correoPersona) {
        this.correoPersona = correoPersona;
    }
    public void setTelefonoPersona(String telefonoPersona){
        this.telefonoPersona = telefonoPersona;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    

}
