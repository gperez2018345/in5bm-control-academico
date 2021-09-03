DROP DATABASE if exists control_academico;

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
  PRIMARY KEY (carne)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
  
-- -----------------------------------------------------
-- Tabla Salon
-- -----------------------------------------------------
  
  CREATE TABLE IF NOT EXISTS Salon (
  salon_id INT NOT NULL AUTO_INCREMENT,
  capacidad INT,
  descripcion VARCHAR(255),
  nombre_salon VARCHAR(255),
  PRIMARY KEY (salon_id)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
  
-- -----------------------------------------------------
-- Tabla Horario
-- -----------------------------------------------------
  
  CREATE TABLE IF NOT EXISTS Horario (
  horario_id INT NOT NULL AUTO_INCREMENT,
  horario_final TIME NOT NULL,
  horario_inicio TIME NOT NULL,
  PRIMARY KEY (horario_id)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
  
-- -----------------------------------------------------
-- Tabla Carrera Tecnica
-- -----------------------------------------------------
  
  CREATE TABLE IF NOT EXISTS CarreraTecnica (
  codigo_carrera  VARCHAR(120) NOT NULL,
  nombre VARCHAR(45),
  PRIMARY KEY (codigo_carrera)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
  
-- -----------------------------------------------------
-- Tabla Instructor
-- -----------------------------------------------------
  
  CREATE TABLE IF NOT EXISTS Instructor (
  instructor_id INT NOT NULL AUTO_INCREMENT,
  apellidos VARCHAR(45),
  nombre VARCHAR(45),
  direccion VARCHAR(45),
  telefono VARCHAR(45),
  PRIMARY KEY (instructor_id)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- -----------------------------------------------------
-- Tabla Curso
-- -----------------------------------------------------
  
  CREATE TABLE IF NOT EXISTS Curso (
  curso_id INT NOT NULL AUTO_INCREMENT,
  ciclo INT,
  cupo_maximo INT,
  cupo_minimo INT,
  descripcion VARCHAR(255),
  codigo_carrera VARCHAR(120) NOT NULL,
  horario_id INT NOT NULL,
  instructor_id INT NOT NULL,
  salon_id INT NOT NULL,
  PRIMARY KEY (curso_id),
  CONSTRAINT FK_Curso_codigo_Carrera
    FOREIGN KEY (codigo_carrera)
    REFERENCES CarreraTecnica (codigo_carrera)
    on delete cascade
			on update cascade,
  CONSTRAINT FK_Curso_horario
    FOREIGN KEY (horario_id)
    REFERENCES Horario (horario_id)
    on delete cascade
			on update cascade,
 CONSTRAINT FK_Curso_instructor
    FOREIGN KEY (instructor_id)
    REFERENCES Instructor (instructor_id)
    on delete cascade
			on update cascade,
CONSTRAINT FK_Curso_salon
    FOREIGN KEY (salon_id)
    REFERENCES Salon (salon_id) 
		on delete cascade
			on update cascade
    )ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


-- -----------------------------------------------------
-- Tabla Asignacion Alumno
-- -----------------------------------------------------
  
  DROP TABLE IF EXISTS AsignacionAlumno;
  CREATE TABLE IF NOT EXISTS AsignacionAlumno (
  asignacion_id VARCHAR(45) NOT NULL,
  carne VARCHAR(16),
  curso_id INT NOT NULL,
  fecha_asignacion DATETIME,
  PRIMARY KEY (asignacion_id),
  CONSTRAINT FK_AsignacionAlumno_carne
    FOREIGN KEY (carne)
    REFERENCES Alumno (carne)
		on delete cascade
			on update cascade,
  CONSTRAINT FK_AsignacionAlumno_curso
    FOREIGN KEY (curso_id)
    REFERENCES Curso (curso_id)
		on delete cascade
			on update cascade
  )ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
  
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

  -- Insersion de datos en la entidad Horario
  INSERT INTO Horario(horario_final, horario_inicio)values("13:00", "7:00");
  INSERT INTO Horario(horario_final, horario_inicio)values("14:00", "10:00");
  INSERT INTO Horario(horario_final, horario_inicio)values("15:00", "10:00");
  INSERT INTO Horario(horario_final, horario_inicio)values("16:00", "11:00");
  INSERT INTO Horario(horario_final, horario_inicio)values("17:00", "11:00");
  INSERT INTO Horario(horario_final, horario_inicio)values("18:00", "12:00");
  INSERT INTO Horario(horario_final, horario_inicio)values("19:00", "12:00");
  INSERT INTO Horario(horario_final, horario_inicio)values("14:00", "10:00");
  INSERT INTO Horario(horario_final, horario_inicio)values("12:00", "7:00");
  INSERT INTO Horario(horario_final, horario_inicio)values("15:00", "8:00");
  
  -- Insersion de datos en la entidad Salon
   insert into Salon(capacidad , descripcion, nombre_salon) values (20 , "Salon para el uso del area tecnica de la carrera de informatica", "C-20");
   insert into Salon(capacidad , descripcion, nombre_salon) values (15 , "Salon para el uso del area tecnica de electricidad", "C-21");
   insert into Salon(capacidad , descripcion, nombre_salon) values (30 , "Salon para el uso del area tecnica de mecanica automotriz", "C-22");
   insert into Salon(capacidad , descripcion, nombre_salon) values (40 , "Salon para el uso del area academica del grado de 4rto perito", "C-23");
   insert into Salon(capacidad , descripcion, nombre_salon) values (40 , "Salon para el uso del area academica del grado de 4rto perito", "C-24");
   insert into Salon(capacidad , descripcion, nombre_salon) values (50 , "Salon para el uso del area academica del grado de 4rto perito", "C-25");
   insert into Salon(capacidad , descripcion, nombre_salon) values (25 , "Salon para el uso del area tecnica de dibujo", "C-26");
   insert into Salon(capacidad , descripcion, nombre_salon) values (20 , "Salon para el uso del area tecnica de informatica", "C-27");
   insert into Salon(capacidad , descripcion, nombre_salon) values (30 , "Salon para el uso del area academica del grado de 5to perito", "C-28");
   insert into Salon(capacidad , descripcion, nombre_salon) values (40 , "Salon para el uso del area academica del grado de 6to perito", "C-29");
   select  * from Salon;
   
   -- Inserción de datos en la entidad: Carrera Tecnica
  
  insert into CarreraTecnica(codigo_carrera, nombre) values("TEC-0001-MECA-INDU","Técnico en mecánica industrial");
  insert into CarreraTecnica(codigo_carrera, nombre) values("TEC-0002-SIST","Técnico en sistemas");
  insert into CarreraTecnica(codigo_carrera, nombre) values("TEC-0003-AUTO","Técnico automotriz");
  insert into CarreraTecnica(codigo_carrera, nombre) values("TEC-0004-MANT-INDU","Técnico en mantenimiento industrial");
  insert into CarreraTecnica(codigo_carrera, nombre) values("TEC-0005-ELECTRI-INDU","Técnico en electricidad indutrial");
  insert into CarreraTecnica(codigo_carrera, nombre) values("TEC-0006-ELME-INDU","Técnico electromecánica industrial");
  insert into CarreraTecnica(codigo_carrera, nombre) values("TEC-0007-ELECTRO-INDU","Técnico en electrónica industrial");
  insert into CarreraTecnica(codigo_carrera, nombre) values("TEC-0008-VEHIC-DIESE","Técnico en vehículos a diésel");
  insert into CarreraTecnica(codigo_carrera, nombre) values("TEC-0009-MECATRO","Técnico en mecatrónica");
  insert into CarreraTecnica(codigo_carrera, nombre) values("TEC-0010-REPA-SOPOR-SISTE","Técnico en reparación y soporte de sistemas");
	select * from CarreraTecnica;

-- Inserción de datos en la entidad: Instructor

	insert into  Instructor(apellidos, nombre, direccion, telefono) 
	values ("Castillo","Rafael","6ta Avenida zona 2","31363445");
	insert into  Instructor(apellidos, nombre, direccion, telefono) 
	values ("Ubeda","Saul","10ma calle zona 11","43567898");
	insert into  Instructor(apellidos, nombre, direccion, telefono) 
	values ("Aguilar","Roberto","16calle A, 6ta Avenida zona 7","12345678");
	insert into  Instructor(apellidos, nombre, direccion, telefono) 
	values ("Rodríguez","Ariel","6ta Calle 9na Avenida zona 10","89012345");
	insert into  Instructor(apellidos, nombre, direccion, telefono) 
	values ("Rodas","Cristian","5ta Avenida 14-48 zona 16","56789123");
	insert into  Instructor(apellidos, nombre, direccion, telefono)
	values ("Urquizu","Santiago","10ma avenida 23calle zona 21","78124565");
	insert into  Instructor(apellidos, nombre, direccion, telefono) 
	values ("Medina","Jorge","6ta Avenida 3ra calle de la zona 15","98765432");
	insert into  Instructor(apellidos, nombre, direccion, telefono) 
	values ("Juarez","Armando","5ta calle 20Avenida zona 11","56657898");
	insert into  Instructor(apellidos, nombre, direccion, telefono) 
	values ("Batres","Moises","17calle diagonal 5 zona 12","34432112");
	insert into  Instructor(apellidos, nombre, direccion, telefono) 
	values ("de León","Carlos","6ta calle 17avenida zona 1","34562109");
	select * from Instructor;

-- Inserción de datos en la entidad: Curso
	INSERT INTO curso (ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) 
	VALUES (2019,375,001,"Orientación en construcción", "TEC-0001-MECA-INDU",1,1,1);
	INSERT INTO curso (ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) 
	VALUES (2020,350,001,"Reparación de computadoras", "TEC-0002-SIST",2,2,2);
	INSERT INTO curso (ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) 
	VALUES (2020,300, 015,"Principios de la mecánica", "TEC-0003-AUTO",3,3,3);
	INSERT INTO curso (ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) 
	VALUES (2021,400, 045,"Mantenimiento industrial", "TEC-0004-MANT-INDU",4,4,4);
	INSERT INTO curso (ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) 
	VALUES (2021,250, 030,"Electricidad y mantenimiento industrial", "TEC-0005-ELECTRI-INDU",5,5,5);
	INSERT INTO curso (ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) 
	VALUES (2021,300, 100,"Electromecánica II", "TEC-0006-ELME-INDU",6,6,6);
	INSERT INTO curso (ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) 
	VALUES (2021,150, 000,"Electronica avanzada", "TEC-0007-ELECTRO-INDU",7,7,7);
	INSERT INTO curso (ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) 
	VALUES (2021,400, 125,"Mecánica Diesel", "TEC-0008-VEHIC-DIESE",8,8,8);
	INSERT INTO curso (ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) 
	VALUES (2021,500, 225,"Mecatronica I", "TEC-0009-MECATRO",9,9,9);
	INSERT INTO curso (ciclo, cupo_maximo, cupo_minimo, descripcion, codigo_carrera, horario_id, instructor_id, salon_id) 
	VALUES (2022,200, 000,"Mantenimiento de sistemas", "TEC-0010-REPA-SOPOR-SISTE",10,10,10);

-- Inserción de datos en la entidad: AsignacionAlumnos
	INSERT INTO AsignacionAlumno(asignacion_id,carne,curso_id,fecha_asignacion) 
	VALUES ("1","2021001","1","2021-01-01 07:00:00");
	INSERT INTO AsignacionAlumno(asignacion_id,carne,curso_id,fecha_asignacion) 
	VALUES ("2","2021002","2","2021-01-02 07:10:00");
    INSERT INTO AsignacionAlumno(asignacion_id,carne,curso_id,fecha_asignacion) 
	VALUES ("3","2021003","3","2021-01-03 07:05:00");
    INSERT INTO AsignacionAlumno(asignacion_id,carne,curso_id,fecha_asignacion) 
	VALUES ("4","2021004","4","2021-01-01 07:08:00");
    INSERT INTO AsignacionAlumno(asignacion_id,carne,curso_id,fecha_asignacion) 
	VALUES ("5","2021005","5","2021-01-02 07:00:00");
    INSERT INTO AsignacionAlumno(asignacion_id,carne,curso_id,fecha_asignacion) 
	VALUES ("6","2021006","6","2021-01-03 07:01:00");
    INSERT INTO AsignacionAlumno(asignacion_id,carne,curso_id,fecha_asignacion) 
	VALUES ("7","2021007","7","2021-01-03 07:00:00");
    INSERT INTO AsignacionAlumno(asignacion_id,carne,curso_id,fecha_asignacion) 
	VALUES ("8","2021008","8","2021-01-04 07:00:00");
    INSERT INTO AsignacionAlumno(asignacion_id,carne,curso_id,fecha_asignacion) 
	VALUES ("9","2021009","9","2021-01-01 07:02:00");
    INSERT INTO AsignacionAlumno(asignacion_id,carne,curso_id,fecha_asignacion) 
	VALUES ("10","2021010","10","2021-01-02 07:10:00");
	SELECT * FROM AsignacionAlumno;
    
    