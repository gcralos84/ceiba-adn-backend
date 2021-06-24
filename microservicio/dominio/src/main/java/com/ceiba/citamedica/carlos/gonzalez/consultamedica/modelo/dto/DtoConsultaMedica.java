package com.ceiba.citamedica.carlos.gonzalez.consultamedica.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Getter
@AllArgsConstructor
public class DtoConsultaMedica {
     private Long  id;
     private String  identificacionEspecialista;
     private String  identificacionPaciente;
     private LocalTime horaCita;
     private LocalDate fechaCita;
     private String tipoUsuario;
     private double cuoataModeradora;

}
