CREATE OR REPLACE  VIEW
    paciente_citamedica  as
SELECT p.identificacion,p.nombre as nombre_paciente,es.nombre as nombre_especialista,especialidad,s.fechaCita,s.cuoataModeradora
FROM consultamedicas s
inner join  pacientes p  on  s.identificacionPaciente =  p.identificacion
inner join  especialistas es on  s.identificacionEspecialista  = es.identificacion;
