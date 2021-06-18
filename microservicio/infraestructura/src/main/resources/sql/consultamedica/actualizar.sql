UPDATE  consultamedicas SET
    identificacionEspecialista = :identificacionEspecialista,
    identificacionPaciente = :identificacionPaciente,
    fechaCita = :fechaCita,
    tipoUsuario = :tipoUsuario
WHERE  id = :id;