select es.id,es.identificacion,es.nombre, es.especialidad  from consultamedicas cm
inner join  especialistas es
on   (cm.fechaCita >= :fechaCita )  and (cm.horaCita != :horaCita) group by es.identificacion;
