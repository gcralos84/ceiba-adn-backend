CREATE OR REPLACE  VIEW
    paciente_citamedica  as
SELECT p.identificacion,p.nombre as nombre,es.nombre as nombreEspecialista,especialidad,s.fechaCita,s.cuoataModeradora
FROM consultamedicas s
inner join  pacientes p  on  s.identificacionPaciente =  p.identificacion
inner join  especialistas es on  s.identificacionEspecialista  = es.identificacion;