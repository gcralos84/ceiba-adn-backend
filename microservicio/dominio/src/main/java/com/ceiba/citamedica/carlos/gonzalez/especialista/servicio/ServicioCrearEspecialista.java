package com.ceiba.citamedica.carlos.gonzalez.especialista.servicio;

import com.ceiba.citamedica.carlos.gonzalez.Mensage;
import com.ceiba.citamedica.carlos.gonzalez.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.citamedica.carlos.gonzalez.especialista.modelo.entidad.Especialista;
import com.ceiba.citamedica.carlos.gonzalez.especialista.puerto.repositorio.RepositorioEspecialista;

public class ServicioCrearEspecialista {
    private  final RepositorioEspecialista repositorioEspecialista;
    private final Mensage EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA  =  Mensage.MENSAGE_USUARIO_YA_RESGISTRADO;
    
    
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
