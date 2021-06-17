package com.ceiba.especialista.servicio;

import com.ceiba.Mensage;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.especialista.modelo.entidad.Especialista;
import com.ceiba.especialista.puerto.repositorio.RepositorioEspecialista;

public class ServicioActualizarEspecialista {
    private final RepositorioEspecialista repositorioEspecialista;
    Mensage EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA  =  Mensage.MENSAGE_USUARIO_YA_RESGISTRADO;
    
    public ServicioActualizarEspecialista(RepositorioEspecialista repositorioEspecialista) {
        this.repositorioEspecialista = repositorioEspecialista;
    }
    
    public void ejecutar(Especialista especialista){
        validarExistenciaPrevia(especialista);
        this.repositorioEspecialista.actualizar(especialista);
    }
    
    private void validarExistenciaPrevia(Especialista especialista) {
      boolean existe = this.repositorioEspecialista.existe(especialista.getIdentificacion());
      if(existe)
          throw  new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA.getMensage());
      
    }
    
    
}
