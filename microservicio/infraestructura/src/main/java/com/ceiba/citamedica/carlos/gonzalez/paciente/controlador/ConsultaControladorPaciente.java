package com.ceiba.citamedica.carlos.gonzalez.paciente.controlador;

import com.ceiba.citamedica.carlos.gonzalez.paciente.modelo.dto.DtoPaciente;
import com.ceiba.citamedica.carlos.gonzalez.paciente.consulta.ManejadorListarPaciente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paciente")
@Api(tags = {"Controlador Consultar Paciente"})
class ConsultaControladorPaciente {
    private final ManejadorListarPaciente manejadorListarPaciente;
    
    public ConsultaControladorPaciente(ManejadorListarPaciente manejadorListarPaciente) {
        this.manejadorListarPaciente = manejadorListarPaciente;
    }
    
    @GetMapping
    @ApiOperation(" Listar paciente")
    public List<DtoPaciente> listar(){
         return   this.manejadorListarPaciente.ejecutar();
    }
}
