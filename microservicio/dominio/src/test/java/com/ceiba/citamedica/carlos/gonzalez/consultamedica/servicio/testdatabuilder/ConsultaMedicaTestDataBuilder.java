package com.ceiba.citamedica.carlos.gonzalez.consultamedica.servicio.testdatabuilder;

import com.ceiba.citamedica.carlos.gonzalez.consultamedica.modelo.entidad.ConsultaMedica;

import java.time.LocalDate;
import java.time.LocalTime;

public class ConsultaMedicaTestDataBuilder {

    private Long  id;
    private String identificacionEspecialista;
    private String identificacionPaciente;
    private LocalTime horaCita;
    private LocalDate fechaCita;
    private String tipoUsuario;
    private Boolean active;

    public ConsultaMedicaTestDataBuilder() {
        LocalDate localDate = LocalDate.of(2021, 06, 30);
        LocalTime localTime = LocalTime.of(07,00,00);
        this.id = 1L;
        this.identificacionEspecialista = "90909090";
        this.identificacionPaciente = "162439861";
        this.horaCita = localTime;
        this.fechaCita = localDate;
        this.tipoUsuario = "TIPO_I";
        this.active = Boolean.TRUE;
    }

    public ConsultaMedicaTestDataBuilder  conId(Long id){
         this.id = id;
         return this;
    }
    public ConsultaMedicaTestDataBuilder conIdentificacionEspecialista( String identificacionEspecialista){
         this.identificacionEspecialista = identificacionEspecialista;
         return this;
    }
    public ConsultaMedicaTestDataBuilder conIdentificacionPaciente(String identificacionPaciente){
        this.identificacionPaciente = identificacionPaciente;
        return this;
    }
    public  ConsultaMedicaTestDataBuilder  conHoraCita( LocalTime horaCita){
        this.horaCita = horaCita;
        return this;
    }
    public ConsultaMedicaTestDataBuilder conFechaCita( LocalDate  fechaCita){
          this.fechaCita = fechaCita;
          return this;
    }
    public ConsultaMedicaTestDataBuilder conTipoUsuario( String tipoUsuario){
        this.tipoUsuario = tipoUsuario;
        return this;
    }
    public ConsultaMedicaTestDataBuilder conActive( Boolean Active){
        this.active = active;
        return this;
    }

    public ConsultaMedica  build(){
        return new ConsultaMedica( id,identificacionEspecialista, identificacionPaciente,
               horaCita, fechaCita,tipoUsuario,active);
    }
}
