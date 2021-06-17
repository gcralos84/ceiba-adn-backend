package com.ceiba.especialista.controlador;

import com.ceiba.especialista.consulta.ManejadorListarEspecialista;
import com.ceiba.especialista.modelo.dto.DtoEspecialista;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/especialistas")
@Api(tags = {"Controlador Consultar Epecialista"})
public class ConsultaControladorEspecialista {
    
    private final ManejadorListarEspecialista manejadorListarEspecialista;
    public ConsultaControladorEspecialista(ManejadorListarEspecialista manejadorListarEspecialista) {
        this.manejadorListarEspecialista = manejadorListarEspecialista;
    }
    @GetMapping
    @ApiOperation(" Listar especialista")
    public List<DtoEspecialista> listar(){
        return   this.manejadorListarEspecialista.ejecutar();
    }
}
