package com.ceiba.citamedica.carlos.gonzalez.consultamedica.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class DtoConsultaMedica {
     private Long  id;
     private String  identificacionEspecialista;
     private String  identificacionPacinete;
     private Date fechaCita;
     private String tipoUsuario;

}