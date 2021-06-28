package com.ceiba.citamedica.carlos.gonzalez.especialista.servicio.testdatabuilder;

import com.ceiba.citamedica.carlos.gonzalez.especialista.ComandoEspecialista;

public class ComandoEspecialistaTestDataBuilder {
    private Long id;
    private String identificacion;
    private String nombre;
    private String especialidad;
    private Boolean active;
    
    public ComandoEspecialistaTestDataBuilder() {
        this.id= 2L;
        this.identificacion="162439866";
        this.nombre="Luis Arturo Gonzalez Alvarez";
        this.especialidad="Medico General";
        this.active = Boolean.TRUE;
    }
    public ComandoEspecialistaTestDataBuilder conId( Long id ){
         this.id= id;
         return this;
    }
    public ComandoEspecialistaTestDataBuilder conIdentificacion( String  identificacion){
         this.identificacion= identificacion;
         return this;
    }
    public ComandoEspecialistaTestDataBuilder conNombre(String nombre){
         this.nombre= nombre;
         return this;
    }
    public  ComandoEspecialistaTestDataBuilder conEspecialidad(String especialidad){
         this.especialidad= especialidad;
         return this;
    }
    public  ComandoEspecialistaTestDataBuilder conActive(Boolean  active){
         this.active= active;
         return this;
    }
    public ComandoEspecialista  build(){
          return new ComandoEspecialista(id,identificacion,nombre,especialidad,active);
    }
    
}
