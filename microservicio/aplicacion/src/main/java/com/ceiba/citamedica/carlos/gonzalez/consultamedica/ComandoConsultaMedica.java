package com.ceiba.citamedica.carlos.gonzalez.consultamedica;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoConsultaMedica {
    private Long  id;
    private String identificacionEspecialista;
    private String identificacionPaciente;
    private LocalTime horaCita;
    private LocalDate fechaCita;
    private String tipoUsuario;
}
