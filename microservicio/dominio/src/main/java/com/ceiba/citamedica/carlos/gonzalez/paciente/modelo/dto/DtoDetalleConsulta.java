package com.ceiba.citamedica.carlos.gonzalez.paciente.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class DtoDetalleConsulta {
    private  String identificacion;
    private  String  nombre;
    private String nombreEspecilista;
    private String especialidad;
    private LocalTime horaCita;
    private LocalDate fechaCita;
    private double cuoataModeradora;

}
