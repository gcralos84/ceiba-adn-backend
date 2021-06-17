package com.ceiba.paciente.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.Mensage;
import com.ceiba.paciente.modelo.entidad.Paciente;
import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;

public class ServicioCrearPaciente {
    
    private  final RepositorioPaciente  repositorioPaciente;
    Mensage  EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA  =  Mensage.MENSAGE_USUARIO_YA_RESGISTRADO;
    
    public ServicioCrearPaciente(RepositorioPaciente repositorioPaciente) {
        this.repositorioPaciente = repositorioPaciente;
    }
    
    public Long  ejecutar(Paciente  paciente){
        validarExistencia(paciente);
        return this.repositorioPaciente.crear(paciente);
    }
    
    private void validarExistencia(Paciente paciente) {
        boolean  existe = this.repositorioPaciente.existe(paciente.getIdentificacion());
        if(existe)
            throw  new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA.getMensage());
    }
    
}
