package com.ceiba.citamedica.carlos.gonzalez.consultamedica.servicios;

import com.ceiba.citamedica.carlos.gonzalez.Mensage;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.puerto.repositorio.RepositorioConsultaMedica;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.modelo.entidad.ConsultaMedica;
import com.ceiba.citamedica.carlos.gonzalez.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActulizarCitaMedica {
     private final RepositorioConsultaMedica repositorioConsultaMedica;
     private final Mensage  LA_CITA_MEDICA_NO_EXISTE  =  Mensage.CITA_MEDICA_NO_EXISTE;

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
