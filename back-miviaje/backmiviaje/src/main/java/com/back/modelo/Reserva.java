package com.back.modelo;


import java.security.SecureRandom;
import java.sql.Date;

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
    private Date fechaInicial;
    private Date fechaFinal;
    private int cantidadPersonas;
    private String nombrePersona;
    private String apellidoPersona;
    private String correoPersona;
    private String telefonoPersona;
    private String tipoDocumento;
    private String numeroDocumento;
    
    // CONSTRUCTORES 
    public Reserva(){}


    public Reserva(String token, Date fechaInicial, Date fechaFinal, int cantidadPersonas, String nombrePersona,
            String apellidoPersona, String correoPersona, String telefonoPersona, String tipoDocumento, String numeroDocumento) {
        //this.token = service.generateRandomString(10);
        this.token = token;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.cantidadPersonas = cantidadPersonas;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.correoPersona = correoPersona;
        this.telefonoPersona = telefonoPersona;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
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

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
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

    //MODIFICADORES // SETTERS

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
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
