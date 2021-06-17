package com.ceiba.citamedica.carlos.gonzalez.paciente.servicio;

import com.ceiba.citamedica.carlos.gonzalez.paciente.puerto.repositorio.RepositorioPaciente;

public class ServicioEliminarPaciente {
    private final RepositorioPaciente repositorioPaciente;
    
    public ServicioEliminarPaciente(RepositorioPaciente repositorioPaciente) {
        this.repositorioPaciente = repositorioPaciente;
    }
     public void  ejecutar( Long id){
         this.repositorioPaciente.eliminar(id);
     }
}
