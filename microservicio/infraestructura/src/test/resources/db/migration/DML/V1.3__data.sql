insert into pacientes(identificacion,nombre,tipoUsuario,fechaNacimiento)
values('94552554','carlos','Tipo I', now());
insert into especialistas(identificacion,nombre,especialidad)
values('16243986','Luis Arturo','Medico General');
insert into consultamedicas(identificacionEspecialista,identificacionPaciente,fechaCita,tipoUsuario)
values('16243986','94552554',now(),'Tipo_II');
