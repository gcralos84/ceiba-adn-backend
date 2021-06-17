package com.ceiba.consultamedica.controlador;

import com.ceiba.consultamedica.consulta.ManejadorListarConsultaMedica;
import com.ceiba.consultamedica.modelo.dto.DtoConsultaMedica;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consultamedica")
@Api(tags = {"Controlador para listar las consultas medicas"})
public class ConsultaControladorConsultaMedica {
    private  final ManejadorListarConsultaMedica manejadorListarConsultaMedica;

    public ConsultaControladorConsultaMedica(ManejadorListarConsultaMedica manejadorListarConsultaMedica) {
        this.manejadorListarConsultaMedica = manejadorListarConsultaMedica;
    }

    @GetMapping
    @ApiOperation(" Listar las consultas medicas")
    public List<DtoConsultaMedica> listar(){
        return   this.manejadorListarConsultaMedica.ejecutar();
    }
}
