CREATE INDEX identificacion_paciente_index ON pacientes(identificacion);
CREATE INDEX identificacion_especialista_index ON especialistas(identificacion);

ALTER TABLE  consultamedicas ADD  CONSTRAINT  identificacionEspecialista_constrains
    FOREIGN KEY (identificacionEspecialista)  REFERENCES  especialistas(identificacion);

ALTER TABLE  consultamedicas ADD  CONSTRAINT  identificacionPaciente_constrains
    FOREIGN KEY (identificacionPaciente)  REFERENCES  pacientes(identificacion);
