package com.ceiba.especialista.servicio.testdatabuilder;

import com.ceiba.especialista.modelo.entidad.Especialista;

public class EspecialistaTestDataBilder {
    
    private Long  id;
    private String identificacion;
    private String nombre;
    private String especialidad;
    
    public EspecialistaTestDataBilder() {
        this.id = 1L;
        this.identificacion = "16243986";
        this.nombre = "Luis Arturo Gonzalez";
        this.especialidad = "Medico General";
    }
    
    
    public EspecialistaTestDataBilder conId( Long id){
         this.id = id;
         return this;
    }
    public EspecialistaTestDataBilder conIdentificacion( String identificacion){
        this.identificacion = identificacion;
        return this;
    }
    public EspecialistaTestDataBilder conNombre(String nombre){
         this.nombre = nombre;
         return this;
    }
    public EspecialistaTestDataBilder conEspecial( String especialidad){
        this.especialidad = especialidad;
        return this;
    }
    public Especialista build(){
        return new Especialista(id,identificacion,nombre,especialidad);
    };
    
}
