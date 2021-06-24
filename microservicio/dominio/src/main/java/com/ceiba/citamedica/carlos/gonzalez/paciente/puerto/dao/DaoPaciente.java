package com.ceiba.citamedica.carlos.gonzalez.paciente.puerto.dao;

import com.ceiba.citamedica.carlos.gonzalez.paciente.modelo.dto.DtoDetalleConsulta;
import com.ceiba.citamedica.carlos.gonzalez.paciente.modelo.dto.DtoPaciente;


import java.util.List;

public interface  DaoPaciente {
    /**
     * Permite listar pacientes
     * @return los pacientes
     */
    List<DtoPaciente> listar();
    List<DtoPaciente> detallePaciente( String  id);
    List<DtoDetalleConsulta> detalleConsulta();
    
    
}
