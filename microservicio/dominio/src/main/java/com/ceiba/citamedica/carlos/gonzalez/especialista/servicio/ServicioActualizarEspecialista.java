package com.ceiba.citamedica.carlos.gonzalez.especialista.servicio;

import com.ceiba.citamedica.carlos.gonzalez.Mensage;
import com.ceiba.citamedica.carlos.gonzalez.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.citamedica.carlos.gonzalez.especialista.modelo.entidad.Especialista;
import com.ceiba.citamedica.carlos.gonzalez.especialista.puerto.repositorio.RepositorioEspecialista;

public class ServicioActualizarEspecialista {
    private final RepositorioEspecialista repositorioEspecialista;
    private static final Mensage EL_ESPECIALISTA_NO_ESTA_RESGISTRADO = Mensage.MENSAGE_ESPECIALISTA_NO_ESTA_RESGISTRADO;
    public ServicioActualizarEspecialista(RepositorioEspecialista repositorioEspecialista) {
        this.repositorioEspecialista = repositorioEspecialista;
    }
    
    public void ejecutar(Especialista especialista, String id ){
        validarExistenciaPrevia(id);
        this.repositorioEspecialista.actualizar(especialista);
    }
    
    private void validarExistenciaPrevia(String id) {
      boolean existe = this.repositorioEspecialista.existe(id);
      if(!existe)
          throw  new ExcepcionDuplicidad(EL_ESPECIALISTA_NO_ESTA_RESGISTRADO.getMensage());
      
    }
    
    
}
