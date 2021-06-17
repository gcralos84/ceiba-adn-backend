package com.ceiba.citamedica.carlos.gonzalez.consultamedica.servicios;

import com.ceiba.citamedica.carlos.gonzalez.consultamedica.puerto.repositorio.RepositorioConsultaMedica;

public class ServicioEliminarCitaMedica {
     private  final RepositorioConsultaMedica repositorioConsultaMedica;

    public ServicioEliminarCitaMedica(RepositorioConsultaMedica repositorioConsultaMedica) {
        this.repositorioConsultaMedica = repositorioConsultaMedica;
    }
    public void  ejecutar( Long id){
         repositorioConsultaMedica.eliminar(id);
    }
}
