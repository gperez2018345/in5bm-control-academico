CREATE DATABASE  IF NOT EXISTS control_academico;
USE control_academico;


-- -----------------------------------------------------
-- Tabla Alumno
-- -----------------------------------------------------
  
  CREATE TABLE IF NOT EXISTS Alumno (
  carne VARCHAR(16) NOT NULL,
  apellidos VARCHAR(45),
  nombres VARCHAR(45),
  email VARCHAR(32) ,
  PRIMARY KEY (carne));
  
-- -----------------------------------------------------
-- Tabla Salon
-- -----------------------------------------------------
  
  CREATE TABLE IF NOT EXISTS Salon (
  salon_id INT NOT NULL AUTO_INCREMENT,
  capacidad INT,
  descripcion VARCHAR(255),
  nombre_salon VARCHAR(255),
  PRIMARY KEY (salon_id));
  
-- -----------------------------------------------------
-- Tabla Horario
-- -----------------------------------------------------
  
  CREATE TABLE IF NOT EXISTS Horario (
  horario_id INT NOT NULL AUTO_INCREMENT,
  horario_final TIME NOT NULL,
  horario_inicio TIME NOT NULL,
  PRIMARY KEY (horario_id));
  
-- -----------------------------------------------------
-- Tabla Carrera Tecnica
-- -----------------------------------------------------
  
  CREATE TABLE IF NOT EXISTS CarreraTecnica (
  codigo_carrera  VARCHAR(120) NOT NULL,
  nombre VARCHAR(45),
  PRIMARY KEY (codigo_carrera));
  
-- -----------------------------------------------------
-- Tabla Instructor
-- -----------------------------------------------------
  
  CREATE TABLE IF NOT EXISTS Instructor (
  instructor_id INT NOT NULL AUTO_INCREMENT,
  apellidos VARCHAR(45),
  nombre VARCHAR(45),
  direccion VARCHAR(45),
  telefono VARCHAR(45),
  PRIMARY KEY (instructor_id));

-- -----------------------------------------------------
-- Tabla Curso
-- -----------------------------------------------------
  
  CREATE TABLE IF NOT EXISTS Curso (
  curso_id INT NOT NULL AUTO_INCREMENT,
  ciclo INT,
  cupo_maximo INT,
  cupo_minimo INT,
  descripcion VARCHAR(255),
  codigoCarrera VARCHAR(120) NOT NULL,
  horario_id INT NOT NULL,
  instructor_id INT NOT NULL,
  salon_id INT NOT NULL,
  PRIMARY KEY (curso_id),
  CONSTRAINT FK_Curso_codigo_Carrera
    FOREIGN KEY (codigoCarrera)
    REFERENCES CarreraTecnica (codigo_carrera),
  CONSTRAINT FK_Curso_horario
    FOREIGN KEY (horario_id)
    REFERENCES Horario (horario_id),
 CONSTRAINT FK_Curso_instructor
    FOREIGN KEY (instructor_id)
    REFERENCES Instructor (instructor_id),
CONSTRAINT FK_Curso_salon
    FOREIGN KEY (salon_id)
    REFERENCES Salon (salon_id) );


-- -----------------------------------------------------
-- Tabla Asignacion Alumno
-- -----------------------------------------------------
  
  CREATE TABLE IF NOT EXISTS AsignacionAlumno (
  asignacion_id VARCHAR(45) NOT NULL,
  carne VARCHAR(16),
  curso_id INT NOT NULL,
  fecha_asignacion DATETIME,
  PRIMARY KEY (asignacion_id),
  CONSTRAINT FK_AsignacionAlumno_carne
    FOREIGN KEY (carne)
    REFERENCES Alumno (carne),
  CONSTRAINT FK_AsignacionAlumno_curso
    FOREIGN KEY (curso_id)
    REFERENCES Curso (curso_id)
  );
  
  -- Insersion de datos en la entidad Alumnos
  INSERT INTO Alumno(carne, apellidos, nombres, email)values("2021001", "Gonzonalez", "Ricardo", "ricardo@gmail.com");
  INSERT INTO Alumno(carne, apellidos, nombres, email)values("2021002", "Perez", "Mariana", "mariana@gmail.com");
  INSERT INTO Alumno(carne, apellidos, nombres, email)values("2021003", "Juarez", "Camila", "camila@gmail.com");
  INSERT INTO Alumno(carne, apellidos, nombres, email)values("2021004", "Perez", "Fernando", "fernando@gmail.com");
  INSERT INTO Alumno(carne, apellidos, nombres, email)values("2021005", "Ponce", "Julieta", "julieta@gmail.com");
  INSERT INTO Alumno(carne, apellidos, nombres, email)values("2021006", "del Carmen", "Maria", "maria@gmail.com");
  INSERT INTO Alumno(carne, apellidos, nombres, email)values("2021007", "Estrada", "Antonio", "antonio@gmail.com");
  INSERT INTO Alumno(carne, apellidos, nombres, email)values("2021008", "Hernandez", "Jose", "jose@gmail.com");
  INSERT INTO Alumno(carne, apellidos, nombres, email)values("2021009", "Ordoñez", "Francisco", "francisco@gmail.com");
  INSERT INTO Alumno(carne, apellidos, nombres, email)values("2021010", "Sical", "Manuel", "manuel@gmail.com");
  

