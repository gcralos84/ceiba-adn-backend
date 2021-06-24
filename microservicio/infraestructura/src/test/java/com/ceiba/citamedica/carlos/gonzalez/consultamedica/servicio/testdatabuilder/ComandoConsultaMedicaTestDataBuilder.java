package com.ceiba.citamedica.carlos.gonzalez.consultamedica.servicio.testdatabuilder;

import com.ceiba.citamedica.carlos.gonzalez.consultamedica.ComandoConsultaMedica;

import java.time.LocalDate;
import java.time.LocalTime;

public class ComandoConsultaMedicaTestDataBuilder {

    private Long  id;
    private String identificacionEspecialista;
    private String identificacionPaciente;
    private LocalTime horaCita;
    private LocalDate fechaCita;
    private String tipoUsuario;
    private double valorCuotaModeradora;

    public ComandoConsultaMedicaTestDataBuilder() {
        LocalDate localDate =   LocalDate.now();
        LocalTime localTime = LocalTime.now();
        this.id =  1L;
        this.identificacionEspecialista = "16243986";
        this.identificacionPaciente = "94552554";
        this.horaCita=localTime;
        this.fechaCita = localDate;
        this.tipoUsuario = "TIPO_II";
        this.valorCuotaModeradora = 3543.228;
    }
    public  ComandoConsultaMedicaTestDataBuilder  conId(Long  id){
         this.id = id;
         return this;
    }
    public ComandoConsultaMedicaTestDataBuilder conIdentificacionEspecialista( String identificacionEspecialista){
        this.identificacionEspecialista = identificacionEspecialista;
        return this;
    }

    public  ComandoConsultaMedicaTestDataBuilder conIdentificacionPaciente( String identificacionPaciente){
        this.identificacionPaciente = identificacionPaciente;
        return this;
    }
    
    public  ComandoConsultaMedicaTestDataBuilder conhoraCita(LocalTime  horaCita){
        this.horaCita = horaCita;
        return this;
    }
    public  ComandoConsultaMedicaTestDataBuilder conFechaCita(LocalDate  fechaCita){
         this.fechaCita = fechaCita;
         return this;
    }
    public  ComandoConsultaMedicaTestDataBuilder conTipoUsuario( String tipoUsuario){
        this.tipoUsuario = tipoUsuario;
        return this;
    }
    public ComandoConsultaMedicaTestDataBuilder conValorCuotaModeradora( double valorCuotaModeradora){
        this.valorCuotaModeradora = valorCuotaModeradora;
        return this;
    }
    public ComandoConsultaMedica  build(){
        return  new  ComandoConsultaMedica(id,identificacionEspecialista,identificacionPaciente,horaCita,fechaCita,tipoUsuario);
    }
}
