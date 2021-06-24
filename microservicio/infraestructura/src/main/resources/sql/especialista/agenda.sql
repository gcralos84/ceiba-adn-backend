select es.id,es.identificacion,es.nombre, es.especialidad  from  especialistas es
 where :fechaCita > curdate()  and  es.identificacion not in (select cm.identificacionEspecialista  from  consultamedicas cm  where  cm.fechaCita = :fechaCita
 and cm.horaCita = :horaCita) group by es.identificacion;
