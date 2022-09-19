package com.back.servicios;

import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.back.modelo.Reserva;

public class ReservaService {
    
    // ATRIBUTOS
    private SessionFactory factory;
    File f = new File("back-miviaje/backmiviaje/src/main/resource/hibernate.cfg.xml");

    // :::: CREAR OBJETO QUE PERMITA FABRICAR SESIONES :::: 
    public ReservaService(){
        factory = new Configuration().configure(f).addAnnotatedClass(Reserva.class).buildSessionFactory();
    }

    // ::::  ABRIR SESION :::: 
    public Session openSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }  

    // :::: CREAR RESERVA :::: //
    public String crearReserva(Reserva reserva){
        String notifacion = "";
        Session session = openSession();
        try {
            session.persist(reserva);
            session.getTransaction().commit();
            notifacion = "Reserva creada con exito";
        } catch (Exception e) {
            notifacion = e.getMessage();
        }
        session.close();
        return notifacion;
    }


    // :::: GENERAR TOKEN ::::

    public static String generarToken(int longitud) {
        String letrasMin = "abcdefghijklmnopqrstuvwxyz";
        String letrasMayu= letrasMin.toUpperCase();
        String numeros = "0123456789";
        String randomToken = letrasMin + letrasMayu + numeros;
        SecureRandom random = new SecureRandom();
    
        if (longitud < 1) throw new IllegalArgumentException();

        StringBuilder tokenFinal= new StringBuilder(longitud);
        
        for (int i = 0; i < longitud; i++) {
            // 0-62 (exclusive), retornos aleatorios 0-61
            int rndCharAt = random.nextInt(randomToken.length());
            char rndChar = randomToken.charAt(rndCharAt);
            tokenFinal.append(rndChar);
        }
        return tokenFinal.toString();
    }
    
     // ::::  OBTENIENDO TODOS LOS DATOS :::: 
     public List<Reserva> getReservas(){
        List<Reserva> reservas = new ArrayList<>();
        Session session = openSession();
        try {
            reservas = session.createQuery("from Reserva", Reserva.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return reservas;
     }

     // ::::  OBTENER POR NUMERO DOCUMENTO :::: 
     public Reserva geReservaNumDocumento(String numeroDocumento){
        Reserva reserva = new Reserva();
        Session session = openSession();
        try {
            reserva = session.find(Reserva.class, numeroDocumento);
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close(); // ??
        return reserva;
    }

    // ::::  OBTENER POR ID :::: 
    public Reserva getReservaId(int idReservas){
        Reserva reserva = new Reserva();
        Session session = openSession();
        try {
            reserva = session.find(Reserva.class, idReservas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close(); // ??
        return reserva;

    }

     // ::::  ACTUALIZAR RESERVA :::: 
     public String actualizarReserva(Reserva reserva){
        String notifacion = "";
        Session session = openSession();
        try {
            session.merge(reserva);
            session.getTransaction().commit();
            notifacion = "Reserva actualizdo con exito";
        } catch (Exception e) {
            e.printStackTrace();
            notifacion = e.getMessage();
        }
        session.close();
        return notifacion;
    }

    // ::::  BORRAR HOTEL :::: 
    public String borrarHotel(int idReservas){
        String notificacion = "";
        Session session = openSession();
        try {
            Reserva reserva = getReservaId(idReservas);
            session.remove(reserva);
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
