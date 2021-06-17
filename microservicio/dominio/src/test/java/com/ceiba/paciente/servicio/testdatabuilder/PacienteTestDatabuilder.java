package com.ceiba.paciente.servicio.testdatabuilder;

import com.ceiba.paciente.modelo.entidad.Paciente;

import java.time.LocalDate;

public class PacienteTestDatabuilder {
    
    private  Long  id;
    private  String identificacion;
    private  String  nombre;
    private  String  tipoUsuario;
    private  LocalDate fechaNacimiento;
    
    public PacienteTestDatabuilder() {
         LocalDate localDate = LocalDate.now();
         identificacion = "94552559";
         nombre="Carlos Arturo  Gonzalez";
         tipoUsuario="Tipo I";
         fechaNacimiento=localDate;
    }
    
    public  PacienteTestDatabuilder  conIdentificacion( String identificacion){
         this.identificacion = identificacion;
         return  this;
    }
    public  PacienteTestDatabuilder conNombre(String nombre){
        this.nombre = nombre;
        return  this;
    }
    public PacienteTestDatabuilder  conTipoUsuario( String tipoUsuario){
        this.tipoUsuario = tipoUsuario;
         return this;
    }
    public  PacienteTestDatabuilder  conFechaNacimiento( LocalDate fechaNacimiento){
        this.fechaNacimiento =fechaNacimiento;
        return  this;
    }
    
    public Paciente build(){
         return   new Paciente( id, identificacion,nombre,tipoUsuario,fechaNacimiento);
    }
    
}
