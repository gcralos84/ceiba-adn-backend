package com.ceiba.consultamedica.servicio.testdatabuilder;

import com.ceiba.consultamedica.modelo.entidad.ConsultaMedica;

import java.time.LocalDate;

public class ConsultaMedicaTestDataBuilder {

    private Long  id;
    private String identificacionEspecialista;
    private String identificacionPaciente;
    private LocalDate fechaCita;
    private String tipoUsuario;

    public ConsultaMedicaTestDataBuilder() {
        LocalDate localDate = LocalDate.now();
        this.id = 1L;
        this.identificacionEspecialista = "90909090";
        this.identificacionPaciente = "162439861";
        this.fechaCita = localDate;
        this.tipoUsuario = "TIPO_I";
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
    public ConsultaMedicaTestDataBuilder conFechaCita( LocalDate  fechaCita){
          this.fechaCita = fechaCita;
          return this;
    }
    public ConsultaMedicaTestDataBuilder conTipoUsuario( String tipoUsuario){
        this.tipoUsuario = tipoUsuario;
        return this;
    }

    public ConsultaMedica  build(){
        return new ConsultaMedica( id,identificacionEspecialista, identificacionPaciente,
                tipoUsuario,fechaCita);
    }
}
