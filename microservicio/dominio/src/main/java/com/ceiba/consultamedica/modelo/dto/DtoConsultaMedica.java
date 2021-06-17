package com.ceiba.consultamedica.modelo.dto;

import com.ceiba.especialista.modelo.dto.DtoEspecialista;
import com.ceiba.paciente.modelo.dto.DtoPaciente;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
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