package com.ceiba.citamedica.carlos.gonzalez.especialista.servicio.testdatabuilder;

import com.ceiba.citamedica.carlos.gonzalez.especialista.modelo.entidad.Especialista;

public class EspecialistaTestDataBilder {
    
    private Long  id;
    private String identificacion;
    private String nombre;
    private String especialidad;
    private  boolean active;
    
    public EspecialistaTestDataBilder() {
        this.id = 1L;
        this.identificacion = "16243986";
        this.nombre = "Luis Arturo Gonzalez";
        this.especialidad = "Medico General";
        this.active=true;
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
    public EspecialistaTestDataBilder conActive(boolean active){
        this.active = active;
        return this;
    }
    public Especialista build(){
        return new Especialista(id,identificacion,nombre,especialidad,active);
    };
    
}
