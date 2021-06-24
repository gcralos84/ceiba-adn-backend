package com.ceiba.citamedica.carlos.gonzalez.paciente.controlador;

import com.ceiba.citamedica.carlos.gonzalez.paciente.consulta.ManejadorDetalleConsulta;
import com.ceiba.citamedica.carlos.gonzalez.paciente.consulta.ManejadorDetallePaciente;
import com.ceiba.citamedica.carlos.gonzalez.paciente.modelo.dto.DtoDetalleConsulta;
import com.ceiba.citamedica.carlos.gonzalez.paciente.modelo.dto.DtoPaciente;
import com.ceiba.citamedica.carlos.gonzalez.paciente.consulta.ManejadorListarPaciente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/paciente")
@Api(tags = {"Controlador Consultar Paciente"})
class ConsultaControladorPaciente {
    private final ManejadorListarPaciente manejadorListarPaciente;
    private final ManejadorDetallePaciente manejadorDetallePaciente;
    private final ManejadorDetalleConsulta manejadorDetalleConsulta;
    
    public ConsultaControladorPaciente(ManejadorListarPaciente manejadorListarPaciente, ManejadorDetallePaciente manejadorDetallePaciente, ManejadorDetalleConsulta manejadorDetalleConsulta) {
        this.manejadorListarPaciente = manejadorListarPaciente;
        this.manejadorDetallePaciente = manejadorDetallePaciente;
        this.manejadorDetalleConsulta = manejadorDetalleConsulta;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(" Listar paciente")
    public List<DtoPaciente> listar(){
         return   this.manejadorListarPaciente.ejecutar();
    }
    
    @RequestMapping(method = RequestMethod.GET,  path="/{identificacion}")
    @ApiOperation(" Listar paciente")
    public List<DtoPaciente> listar(@PathVariable String identificacion ){
        return   this.manejadorDetallePaciente.ejecutar(identificacion);
    }
    @RequestMapping(method = RequestMethod.GET,  path="/hitorial")
    @ApiOperation(" Listar paciente")
    public List<DtoDetalleConsulta> historialCitas(){
        return   this.manejadorDetalleConsulta.ejecutar();
    }
}
