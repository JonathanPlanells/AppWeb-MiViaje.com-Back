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
    File f = new File("src/main/resource/hibernate.cfg.xml");

    // :::: CREAR OBJETO QUE PERMITA FABRICAR SESIONES ::::
    public ReservaService() {
        factory = new Configuration().configure(f).addAnnotatedClass(Reserva.class).buildSessionFactory();
    }

    // :::: ABRIR SESION ::::
    public Session openSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    // :::: CREAR RESERVA :::: //
    public String crearReserva(Reserva reserva) {
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
        String letrasMayu = letrasMin.toUpperCase();
        String numeros = "0123456789";
        String randomToken = letrasMayu + numeros;
        SecureRandom random = new SecureRandom();
        if (longitud < 1)
            throw new IllegalArgumentException();
        StringBuilder tokenFinal = new StringBuilder(longitud);
        for (int i = 0; i < longitud; i++) {
            // 0-62 (exclusive), retornos aleatorios 0-61
            int rndCharAt = random.nextInt(randomToken.length());
            char rndChar = randomToken.charAt(rndCharAt);
            tokenFinal.append(rndChar);
        }
        return tokenFinal.toString();
    }

    // :::: OBTENIENDO TODOS LOS DATOS ::::
    public List<Reserva> getReservas() {
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


    // :::: OBTENER POR NUMERO DOCUMENTO Y NUMERO DE RESERVA::::
    public Reserva getReservaNumDocumentoToken(String numeroDocumento, String token, String tipoDocumento) {
        Reserva reserva = new Reserva();
        Session session = openSession();
        try {
            List<Reserva> list = session
                    .createQuery("from Reserva where numeroDocumento = :numeroDocumento and token = :token and tipoDocumento = :tipoDocumento", Reserva.class)
                    .setParameter("numeroDocumento", numeroDocumento)
                    .setParameter("token", token)
                    .setParameter("tipoDocumento", tipoDocumento)
                    .list();
            if (list.size() > 0) {
                reserva = list.get(0);
            }
            // reserva = session.find(Reserva.class, numeroDocumento);
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close(); 
        return reserva;
    }

    // :::: OBTENER POR ID ::::
    public Reserva getReservaId(int idReservas) {
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

    // :::: OBTENER TOKEN POR NUMERO DE DOCUMENTO::::
    public List<Reserva> getID_TOKEN(String numeroDocumento) {
       List<Reserva> reservas = new ArrayList<>();
        Session session = openSession();
        try {
            reservas = session.createQuery("SELECT token FROM Reserva r WHERE r.numeroDocumento = :numeroDocumento", Reserva.class)
            .setParameter("numeroDocumento", numeroDocumento).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close(); // ??
        return reservas;
    }

    // :::: OBTENER TOKEN POR NUMERO DE DOCUMENTO - TIPO DE DOCUMENTO - APELLIDO::::
    public List<Reserva> getTOKEN_porIDYyTipo(String numeroDocumento, String tipoDocumento, String correoPersona) {
        List<Reserva> reservas = new ArrayList<>();
         Session session = openSession();
         try {
             reservas = session.createQuery("SELECT token FROM Reserva r WHERE r.numeroDocumento = :numeroDocumento and r.tipoDocumento = :tipoDocumento and r.correoPersona = :correoPersona", Reserva.class)
             .setParameter("numeroDocumento", numeroDocumento)
             .setParameter("tipoDocumento",tipoDocumento)
             .setParameter("correoPersona",correoPersona).
             list();
         } catch (Exception e) {
             e.printStackTrace();
         }
         session.close(); // ??
         return reservas;
     }

    // :::: ACTUALIZAR RESERVA ::::
    public String actualizarReserva(Reserva reserva) {
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

    // :::: BORRAR HOTEL ::::
    public String borrarReserva(int idReservas) {
        String notificacion = "";
        Session session = openSession();
        try {
            Reserva reserva = getReservaId(idReservas);
            session.remove(reserva);
            session.getTransaction().commit();
            notificacion = "Reserva eliminda con exito";
        } catch (Exception e) {
            e.printStackTrace();
            notificacion = e.getMessage();
        }
        session.close();
        return notificacion;
    }

}
