package com.ceiba.especialista.servicio;

import com.ceiba.especialista.puerto.repositorio.RepositorioEspecialista;

public class ServicioEliminarEspecialista {
    
    private final RepositorioEspecialista  repositorioEspecialista;
    
    public ServicioEliminarEspecialista(RepositorioEspecialista repositorioEspecialista) {
        this.repositorioEspecialista = repositorioEspecialista;
    }
    public void  ejecutar( Long id){
        repositorioEspecialista.eliminar(id);
    }
}
