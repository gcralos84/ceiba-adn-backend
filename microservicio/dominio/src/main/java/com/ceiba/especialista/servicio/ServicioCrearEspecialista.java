package com.ceiba.especialista.servicio;

import com.ceiba.Mensage;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.especialista.modelo.entidad.Especialista;
import com.ceiba.especialista.puerto.repositorio.RepositorioEspecialista;

public class ServicioCrearEspecialista {
    private  final RepositorioEspecialista repositorioEspecialista;
    Mensage EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA  =  Mensage.MENSAGE_USUARIO_YA_RESGISTRADO;
    
    
    public ServicioCrearEspecialista(RepositorioEspecialista repositorioEspecialista) {
        this.repositorioEspecialista = repositorioEspecialista;
    }
    
    public  Long  ejecutar( Especialista especialista){
        validarExistencia(especialista);
        return this.repositorioEspecialista.crear(especialista);
    }
    
    private void validarExistencia(Especialista especialista) {
          boolean existe = this.repositorioEspecialista.existe(especialista.getIdentificacion());
          if(existe)
              throw  new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA.getMensage());
    }
    
}
