package com.ceiba.citamedica.carlos.gonzalez.especialista.servicio;

import com.ceiba.citamedica.carlos.gonzalez.especialista.puerto.repositorio.RepositorioEspecialista;

public class ServicioEliminarEspecialista {
    
    private final RepositorioEspecialista  repositorioEspecialista;
    
    public ServicioEliminarEspecialista(RepositorioEspecialista repositorioEspecialista) {
        this.repositorioEspecialista = repositorioEspecialista;
    }
    public void  ejecutar( Long id){
        repositorioEspecialista.eliminar(id);
    }
}
