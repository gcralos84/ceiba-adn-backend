CREATE  TABLE IF NOT EXISTS  pacientes(
  id integer primary key  auto_increment,
  identificacion  varchar(50) not null,
  nombre  varchar(50) not null,
  tipoUsuario varchar(10) not null,
  fechaNacimiento  timestamp
);
CREATE  TABLE IF NOT EXISTS  especialistas(
  id integer primary key  auto_increment,
  identificacion  varchar(50) not null,
  nombre  varchar(50) not null,
  especialidad varchar(50) not null
);
CREATE TABLE IF NOT EXISTS  consultamedicas(
       id  integer primary key auto_increment,
       identificacionEspecialista   varchar(50) not null,
       identificacionPaciente varchar(50) not null,
       horaCita time not null,
       fechaCita  date  not null,
       tipoUsuario varchar(10) not null,
       cuoataModeradora  decimal(9,3)
);
