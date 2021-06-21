package com.ceiba.citamedica.carlos.gonzalez.paciente.controlador;

import com.ceiba.citamedica.carlos.gonzalez.paciente.modelo.dto.DtoPaciente;
import com.ceiba.citamedica.carlos.gonzalez.paciente.consulta.ManejadorListarPaciente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/paciente")
@Api(tags = {"Controlador Consultar Paciente"})
class ConsultaControladorPaciente {
    private final ManejadorListarPaciente manejadorListarPaciente;
    
    public ConsultaControladorPaciente(ManejadorListarPaciente manejadorListarPaciente) {
        this.manejadorListarPaciente = manejadorListarPaciente;
    }
    
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(" Listar paciente")
    public List<DtoPaciente> listar(){
         return   this.manejadorListarPaciente.ejecutar();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET,  path="/{identificacion}")
    @ApiOperation(" Listar paciente")
    public List<DtoPaciente> listar(@PathVariable String identificacion ){
        return   this.manejadorListarPaciente.ejecutar()
                .stream().filter(x -> x.getIdentificacion().equals(identificacion)).collect(Collectors.toList());
    }
}
