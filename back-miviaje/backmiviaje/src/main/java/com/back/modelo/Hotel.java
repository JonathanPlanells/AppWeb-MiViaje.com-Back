package com.back.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "hoteles")

public class Hotel {

    // ATRIBUTOS
    @Id
    private int idHoteles;
    private String nombreHotel;
    private String ciudad;
    private int totalHabitaciones;
    private int disponibleHabitaciones;
    private String costoHabitacion;
    private String imagen;

    public Hotel(){}

    public Hotel(int idHoteles, String nombreHotel, String ciudad, int totalHabitaciones, int disponibleHabitaciones,
            String costoHabitacion, String imagen) {
        this.idHoteles = idHoteles;
        this.nombreHotel = nombreHotel;
        this.ciudad = ciudad;
        this.totalHabitaciones = totalHabitaciones;
        this.disponibleHabitaciones = disponibleHabitaciones;
        this.costoHabitacion = costoHabitacion;
        this.imagen = imagen;
    }

    // CONSULTORES // GETTERS
    public int getIdHoteles(){
        return idHoteles;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getTotalHabitaciones() {
        return totalHabitaciones;
    }

    public int getDisponibleHabitaciones() {
        return disponibleHabitaciones;
    }

    public String getCostoHabitacion() {
        return costoHabitacion;
    }

    public String getImagen() {
        return imagen;
    }
    
    //MODIFICADORES // SETTERS

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setTotalHabitaciones(int totalHabitaciones) {
        this.totalHabitaciones = totalHabitaciones;
    }

    public void setDisponibleHabitaciones(int disponibleHabitaciones) {
        this.disponibleHabitaciones = disponibleHabitaciones;
    }

    public void setCostoHabitacion(String costoHabitacion) {
        this.costoHabitacion = costoHabitacion;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
   
}
