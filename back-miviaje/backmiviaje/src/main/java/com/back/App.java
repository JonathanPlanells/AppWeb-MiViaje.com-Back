package com.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class App 
{
    public static void main( String[] args ){
        SpringApplication.run(App.class, args);
    }

    // Darle permisos a todos los puertos o dominos
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry){
                // Si tenemos varios controladores se duplica "registry.addMapping("/mascotas").allowedOrigins("*");" y se cambia la ruta addMapping
                // cambiamos * por el dominio o puerto para dar permiso en especifico
                registry.addMapping("/hoteles").allowedOrigins("*"); 
                registry.addMapping("/hoteles/bogota").allowedOrigins("*"); 
                registry.addMapping("/reservas").allowedOrigins("*"); 
            }
            
        };
    }

}
