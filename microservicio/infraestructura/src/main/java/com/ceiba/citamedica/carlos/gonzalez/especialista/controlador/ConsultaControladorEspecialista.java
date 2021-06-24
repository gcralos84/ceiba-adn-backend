package com.ceiba.citamedica.carlos.gonzalez.especialista.controlador;

import com.ceiba.citamedica.carlos.gonzalez.especialista.consulta.ManejadorListarCosultarAgenda;
import com.ceiba.citamedica.carlos.gonzalez.especialista.modelo.dto.DtoEspecialista;
import com.ceiba.citamedica.carlos.gonzalez.especialista.consulta.ManejadorListarEspecialista;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/especialistas")
@Api(tags = {"Controlador Consultar Epecialista"})
public class ConsultaControladorEspecialista {
    
    private final ManejadorListarEspecialista manejadorListarEspecialista;
    private final ManejadorListarCosultarAgenda manejadorListarCosultarAgenda;
    
    public ConsultaControladorEspecialista(ManejadorListarEspecialista manejadorListarEspecialista, ManejadorListarCosultarAgenda manejadorListarCosultarAgenda) {
        this.manejadorListarEspecialista = manejadorListarEspecialista;
        this.manejadorListarCosultarAgenda = manejadorListarCosultarAgenda;
    }
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(" Listar especialista")
    public List<DtoEspecialista> listar(){
        return   this.manejadorListarEspecialista.ejecutar();
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/{fechaCita}/{horaCita}")
    @ApiOperation(" Listar agenda")
    public List<DtoEspecialista> listarConsultaAgenda(@PathVariable String fechaCita, @PathVariable String horaCita){
        return   this.manejadorListarCosultarAgenda.ejecutar(fechaCita, horaCita);
    }
    
}
