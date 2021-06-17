UPDATE  pacientes SET
    identificacion = :identificacion,
    nombre = :nombre,
    tipoUsuario = :tipoUsuario,
    fechaNacimiento = :fechaNacimiento
where  id =:id
