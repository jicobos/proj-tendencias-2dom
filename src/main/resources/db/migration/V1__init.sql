CREATE TABLE IF NOT EXISTS  clientes
    (id serial,
    nombre VARCHAR(45) NOT NULL,
    apellido VARCHAR(45) NOT NULL,
    cedula VARCHAR(45) NOT NULL,
    direccion VARCHAR(45) NOT NULL,
    correo VARCHAR (45) NOT NULL,
    telefono VARCHAR (45) NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS  mascotas
    (id serial,
    nombre VARCHAR(45) NOT NULL,
    tipo VARCHAR(45) NOT NULL,
    raza VARCHAR(45) NOT NULL,
    edad VARCHAR(45) NOT NULL,
    tipoComida VARCHAR(45) NOT NULL,
    enfermedades VARCHAR(45),
    idCliente int ,
    PRIMARY KEY (id),
    FOREIGN KEY (idCliente) REFERENCES clientes (id)
    );

CREATE TABLE IF NOT EXISTS  hospedaje
    (id serial,
    fechaIngreso VARCHAR(45) NOT NULL,
    fechaSalida VARCHAR(45),
    numeroHabitacion VARCHAR(45) NOT NULL,
    idMascota int ,
    PRIMARY KEY (id),
    FOREIGN KEY (idMascota) REFERENCES mascotas (id)
    );

CREATE TABLE IF NOT EXISTS  servicio
    (id serial,
    tipoServicio VARCHAR(45) NOT NULL,
    idHospedaje int ,
    PRIMARY KEY (id),
    FOREIGN KEY (idHospedaje) REFERENCES hospedaje (id)
    );