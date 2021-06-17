package com.ceiba.citamedica.carlos.gonzalez.paciente.servicio;

import com.ceiba.citamedica.carlos.gonzalez.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.citamedica.carlos.gonzalez.Mensage;
import com.ceiba.citamedica.carlos.gonzalez.paciente.modelo.entidad.Paciente;
import com.ceiba.citamedica.carlos.gonzalez.paciente.puerto.repositorio.RepositorioPaciente;

public class ServicioActualizarPaciente {
    private  final RepositorioPaciente repositorioPaciente;
    Mensage EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA  =  Mensage.MENSAGE_USUARIO_YA_RESGISTRADO;
    
    public ServicioActualizarPaciente(RepositorioPaciente repositorioPaciente) {
        this.repositorioPaciente = repositorioPaciente;
    }
    public void  ejecutar( Paciente paciente){
        validarExistenciaPrevia(paciente);
        this.repositorioPaciente.actualizar(paciente);
    }
    
    private void validarExistenciaPrevia(Paciente paciente) {
        boolean  existe = this.repositorioPaciente.existe(paciente.getIdentificacion());
        if(existe)
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA.getMensage());
    }
}
