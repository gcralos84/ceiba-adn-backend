package com.ceiba.citamedica.carlos.gonzalez.paciente.controlador;

import com.ceiba.citamedica.carlos.gonzalez.ComandoRespuesta;
import com.ceiba.citamedica.carlos.gonzalez.paciente.comando.ComandoPaciente;
import com.ceiba.citamedica.carlos.gonzalez.paciente.comando.manejador.ManejadorActulizarPaciente;
import com.ceiba.citamedica.carlos.gonzalez.paciente.comando.manejador.ManejadorCrearPaciente;
import com.ceiba.citamedica.carlos.gonzalez.paciente.comando.manejador.ManejadorEliminarPaciente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
@Api(tags={"Controlador comando  paciente"})
public class ComandoControladorPaciente {
    
    private final ManejadorCrearPaciente manejadorCrearPaciente;
    private final ManejadorActulizarPaciente manejadorActulizarPaciente;
    private final ManejadorEliminarPaciente manejadorEliminarPaciente;
    
    public ComandoControladorPaciente(ManejadorCrearPaciente manejadorCrearPaciente, ManejadorActulizarPaciente manejadorActulizarPaciente, ManejadorEliminarPaciente manejadorEliminarPaciente) {
        this.manejadorCrearPaciente = manejadorCrearPaciente;
        this.manejadorActulizarPaciente = manejadorActulizarPaciente;
        this.manejadorEliminarPaciente = manejadorEliminarPaciente;
    }
    @PostMapping
    @ApiOperation("Crear Paciente")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPaciente comandoPaciente){
        return  manejadorCrearPaciente.ejecutar(comandoPaciente);
    }
    @PutMapping("/{id}")
    @ApiOperation("Actualizar  paciente")
    public void actualizar( @RequestBody  ComandoPaciente comandoPaciente,  @PathVariable Long id){
         comandoPaciente.setId(id);
       manejadorActulizarPaciente.ejecutar(comandoPaciente);
    }
    @DeleteMapping("/{id}")
    @ApiOperation("Eliminar paciente")
    public void  eliminar(@PathVariable String id){
        manejadorEliminarPaciente.ejecutar(Long.valueOf(id));
    }
    
}
