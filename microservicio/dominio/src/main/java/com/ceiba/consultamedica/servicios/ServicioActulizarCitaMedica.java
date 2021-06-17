package com.ceiba.consultamedica.servicios;

import com.ceiba.Mensage;
import com.ceiba.consultamedica.modelo.entidad.ConsultaMedica;
import com.ceiba.consultamedica.puerto.repositorio.RepositorioConsultaMedica;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActulizarCitaMedica {
     private  final RepositorioConsultaMedica  repositorioConsultaMedica;
     Mensage  LA_CITA_MEDICA_NO_EXISTE  =  Mensage.CITA_MEDICA_NO_EXISTE;

    public ServicioActulizarCitaMedica(RepositorioConsultaMedica repositorioConsultaMedica) {
        this.repositorioConsultaMedica = repositorioConsultaMedica;
    }

    public void  ejecutar( ConsultaMedica consultaMedica){
        validarExistenciaPrevia(consultaMedica);
        this.repositorioConsultaMedica.actualizar(consultaMedica);
    }

    private void validarExistenciaPrevia(ConsultaMedica consultaMedica) {
        boolean  existe = this.repositorioConsultaMedica.existe(consultaMedica.getId());
        if(!existe)
             throw  new ExcepcionDuplicidad(LA_CITA_MEDICA_NO_EXISTE.getMensage());
    }
}
