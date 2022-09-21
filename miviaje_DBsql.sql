
show databases;

CREATE database miviaje_db;

show tables;

ALTER TABLE hoteles RENAME COLUMN id TO idHoteles;

CREATE TABLE hoteles (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombreHotel VARCHAR(45) NOT NULL,
    ciudad VARCHAR(45) NOT NULL,
    totalHabitaciones INT NOT NULL,
    disponibleHabitaciones INT NOT NULL,
    costoHabitacion VARCHAR(45) NOT NULL,
    imagen TEXT NOT NULL
);

CREATE TABLE reservas (
	idReservas INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    token VARCHAR(45) NOT NULL,
    fechaInicial DATE NOT NULL,
    fechaFinal DATE NOT NULL,
    cantidadPersonas INT NOT NULL,
    nombrePersona VARCHAR(45) NOT NULL,
    apellidoPersona VARCHAR(45) NOT NULL,
    correoPersona VARCHAR(45) NOT NULL,
    telefonoPersona VARCHAR(45) NOT NULL,
    tipoDocumento CHAR(2),
    numeroDocumento VARCHAR(30)
);




CREATE TABLE pvhotelreserva(
	idreservasHoteles INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	fkHoteles INT,
    fkReserva INT,
    FOREIGN KEY (fkHoteles) REFERENCES hoteles (idHoteles),
    FOREIGN KEY (fkReserva) REFERENCES reservas (idReservas)
);

CREATE TABLE contacto (
	idContacto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombreContacto VARCHAR(45) NOT NULL,
    apellidoContacto VARCHAR(45) NOT NULL,
    correoContacto VARCHAR(45) NOT NULL,
    telefonoContacto VARCHAR(45) NOT NULL,
    mensajeContacto TEXT NOT NULL
);


SELECT * FROM  hoteles;
SELECT * FROM reservas;
SELECT * FROM pvhotelreserva;