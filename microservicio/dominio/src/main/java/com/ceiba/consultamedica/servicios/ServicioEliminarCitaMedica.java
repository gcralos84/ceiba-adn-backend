package com.ceiba.consultamedica.servicios;

import com.ceiba.consultamedica.puerto.repositorio.RepositorioConsultaMedica;

public class ServicioEliminarCitaMedica {
     private  final RepositorioConsultaMedica  repositorioConsultaMedica;

    public ServicioEliminarCitaMedica(RepositorioConsultaMedica repositorioConsultaMedica) {
        this.repositorioConsultaMedica = repositorioConsultaMedica;
    }
    public void  ejecutar( Long id){
         repositorioConsultaMedica.eliminar(id);
    }
}
