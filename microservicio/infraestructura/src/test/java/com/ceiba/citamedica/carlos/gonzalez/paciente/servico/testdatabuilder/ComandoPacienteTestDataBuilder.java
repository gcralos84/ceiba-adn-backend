package com.ceiba.citamedica.carlos.gonzalez.paciente.servico.testdatabuilder;

import com.ceiba.citamedica.carlos.gonzalez.paciente.comando.ComandoPaciente;

import java.time.LocalDate;

public class ComandoPacienteTestDataBuilder {
    private  Long  id;
    private  String identificacion;
    private  String  nombre;
    private  String  tipoUsuario;
    private LocalDate fechaNacimiento;
    
    public ComandoPacienteTestDataBuilder() {
        LocalDate localDate = LocalDate.now();
        id=1L;
        identificacion = "945525541";
        nombre="Carlos Arturo  Gonzalez";
        tipoUsuario="Tipo I";
        fechaNacimiento=localDate;
    }
    
    public  ComandoPacienteTestDataBuilder conId(Long id){
         this.id = id;
         return this;
    }
    public ComandoPacienteTestDataBuilder  conIdentificacion( String identificacion){
        this.identificacion = identificacion;
        return this;
    }
    public  ComandoPacienteTestDataBuilder conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }
    
    public ComandoPacienteTestDataBuilder conTipoUsuario( String tipoUsuario){
         this.tipoUsuario = tipoUsuario;
         return this;
    }
    public ComandoPacienteTestDataBuilder conFechaNacimiento( LocalDate  fechaNacimiento){
          this.fechaNacimiento = fechaNacimiento;
          return this;
    }
     public ComandoPaciente  build(){
         return new ComandoPaciente(id,identificacion,nombre,tipoUsuario,fechaNacimiento);
     }
}
