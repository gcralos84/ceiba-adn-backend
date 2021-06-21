package com.ceiba.citamedica.carlos.gonzalez.paciente.servicio;

import com.ceiba.citamedica.carlos.gonzalez.paciente.puerto.repositorio.RepositorioPaciente;
import com.ceiba.citamedica.carlos.gonzalez.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.citamedica.carlos.gonzalez.Mensage;
import com.ceiba.citamedica.carlos.gonzalez.paciente.modelo.entidad.Paciente;

public class ServicioCrearPaciente {
    
    private  final RepositorioPaciente repositorioPaciente;
    private final Mensage  EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA  =  Mensage.MENSAGE_USUARIO_YA_RESGISTRADO;
    
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
