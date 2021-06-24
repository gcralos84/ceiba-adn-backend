package com.ceiba.citamedica.carlos.gonzalez.paciente.consulta;

import com.ceiba.citamedica.carlos.gonzalez.paciente.modelo.dto.DtoDetalleConsulta;
import com.ceiba.citamedica.carlos.gonzalez.paciente.modelo.dto.DtoPaciente;
import com.ceiba.citamedica.carlos.gonzalez.paciente.puerto.dao.DaoPaciente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorDetalleConsulta {
    private final DaoPaciente daoPaciente;
    
    
    public ManejadorDetalleConsulta(DaoPaciente daoPaciente) {
        this.daoPaciente = daoPaciente;
    }
    public List<DtoDetalleConsulta> ejecutar(){
        return this.daoPaciente.detalleConsulta();
    }
}
