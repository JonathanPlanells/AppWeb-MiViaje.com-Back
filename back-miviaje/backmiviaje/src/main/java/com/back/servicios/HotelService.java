package com.back.servicios;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.back.modelo.Hotel;

public class HotelService {

    // ATRIBUTOS
    private SessionFactory factory;
    File f = new File("back-miviaje/backmiviaje/src/main/resource/hibernate.cfg.xml");

    // :::: CREAR OBJETO QUE PERMITA FABRICAR SESIONES :::: 
    public HotelService(){
        factory = new Configuration().configure(f).addAnnotatedClass(Hotel.class).buildSessionFactory();
    }

    // ::::  ABRIR SESION :::: 
    public Session openSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }  

    // :::: CREAR HOTEL :::: //
    public String create(Hotel hotel){
        String respuesta = "";
        Session session = openSession();
        try {
            session.persist(hotel);
            session.getTransaction().commit();
            respuesta = "Hotel Creado con exito";
        } catch (Exception e) {
            e.printStackTrace();
            respuesta = e.getMessage();
        }
        session.close();
        return respuesta;
    }

    // ::::  OBTENIENDO TODOS LOS DATOS :::: 
    public List<Hotel> getHoteles(){
        List<Hotel> hoteles = new ArrayList<>();
        Session session = openSession();
        try {
            hoteles = session.createQuery("from Hotel", Hotel.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return hoteles;
    }

    // ::::  OBTENER POR ID :::: 
    public Hotel getHotelId(int idHoteles){
        Hotel hotel = new Hotel();
        Session session = openSession();
        try {
            hotel = session.find(Hotel.class, idHoteles);
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close(); // ??
        return hotel;

    }

    // ::::  OBTENER POR CIUDAD :::: 

    public List<Hotel> getHotelCiudad(String ciudad){
        List<Hotel> hoteles = new ArrayList<>();
        Session session = openSession();
        try {
            hoteles = session.createQuery("from Hotel where ciudad = :ciudad", Hotel.class).setParameter("ciudad", ciudad).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return hoteles;

    }

    // ::::  ACTUALIZAR HOTEL :::: 

    public String actualizarHotel(Hotel hotel){
        String notifacion = "";
        Session session = openSession();
        try {
            session.merge(hotel);
            session.getTransaction().commit();
            notifacion = "Hotel actualizdo con exito";
        } catch (Exception e) {
            e.printStackTrace();
            notifacion = e.getMessage();
        }
        session.close();
        return notifacion;
    }

    // ::::  BORRAR HOTEL :::: 
    
    public String borrarHotel(int idHoteles){
        String notificacion = "";
        Session session = openSession();
        try {
            Hotel hotel= getHotelId(idHoteles);
            session.remove(hotel);
            session.getTransaction().commit();
            notificacion = "Hotel elimindo con exito";
        } catch (Exception e) {
            e.printStackTrace();
            notificacion = e.getMessage();
        }
        session.close();
        return notificacion;
    }


}

