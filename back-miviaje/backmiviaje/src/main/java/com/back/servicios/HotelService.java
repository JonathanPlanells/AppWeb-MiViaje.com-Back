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
    File f = new File("backmiviaje/src/main/resource/hibernate.cfg.xml");

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



}

