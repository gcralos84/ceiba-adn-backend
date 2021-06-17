package com.ceiba.citamedica.carlos.gonzalez.paciente.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoPaciente {
    private  Long  id;
    private  String identificacion;
    private  String  nombre;
    private  String  tipoUsuario;
    private LocalDate  fechaNacimineto;
}
