package com.ceiba.citamedica.carlos.gonzalez.usuario.controlador;

import com.ceiba.citamedica.carlos.gonzalez.usuario.modelo.dto.DtoUsuario;
import com.ceiba.citamedica.carlos.gonzalez.usuario.consulta.ManejadorListarUsuarios;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Api(tags={"Controlador consulta usuario"})
public class ConsultaControladorUsuario {

    private final ManejadorListarUsuarios manejadorListarUsuarios;

    public ConsultaControladorUsuario(ManejadorListarUsuarios manejadorListarUsuarios) {
        this.manejadorListarUsuarios = manejadorListarUsuarios;
    }

    @GetMapping
    @ApiOperation("Listar Usuarios")
    public List<DtoUsuario> listar() {
        return this.manejadorListarUsuarios.ejecutar();
    }

}
