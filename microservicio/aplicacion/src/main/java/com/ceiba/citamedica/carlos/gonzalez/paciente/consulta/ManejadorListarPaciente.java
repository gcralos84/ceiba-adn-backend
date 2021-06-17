package com.ceiba.citamedica.carlos.gonzalez.paciente.consulta;

import com.ceiba.citamedica.carlos.gonzalez.paciente.modelo.dto.DtoPaciente;
import com.ceiba.citamedica.carlos.gonzalez.paciente.puerto.dao.DaoPaciente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPaciente {
    
    private final DaoPaciente daoPaciente;
    public ManejadorListarPaciente(DaoPaciente daoPaciente) {
        this.daoPaciente = daoPaciente;
    }
    public List<DtoPaciente>  ejecutar(){
         return this.daoPaciente.listar();
    }
}
