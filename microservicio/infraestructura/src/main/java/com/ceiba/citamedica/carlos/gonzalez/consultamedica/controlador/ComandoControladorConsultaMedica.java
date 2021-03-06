package com.ceiba.citamedica.carlos.gonzalez.consultamedica.controlador;

import com.ceiba.citamedica.carlos.gonzalez.ComandoRespuesta;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.ComandoConsultaMedica;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.comando.manejador.ManejadorActulizarConsultaMedica;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.comando.manejador.ManejadorCrearConsultaMedica;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.comando.manejador.ManejadorEliminarConsultaMedica;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/consultamedica")
@Api(tags={"Controlador comando  consulta medica"})
public class ComandoControladorConsultaMedica {

    private final ManejadorCrearConsultaMedica manejadorCrearConsultaMedica;
    private final ManejadorActulizarConsultaMedica manejadorActulizarConsultaMedica;
    private final ManejadorEliminarConsultaMedica manejadorEliminarConsultaMedica;

    public ComandoControladorConsultaMedica(ManejadorCrearConsultaMedica manejadorCrearConsultaMedica, ManejadorActulizarConsultaMedica manejadorActulizarConsultaMedica, ManejadorEliminarConsultaMedica manejadorEliminarConsultaMedica) {
        this.manejadorCrearConsultaMedica = manejadorCrearConsultaMedica;
        this.manejadorActulizarConsultaMedica = manejadorActulizarConsultaMedica;
        this.manejadorEliminarConsultaMedica = manejadorEliminarConsultaMedica;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation("Crear  cita medica")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoConsultaMedica comandoConsultaMedica){
        return  manejadorCrearConsultaMedica.ejecutar(comandoConsultaMedica);
    }
    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar consulta medica")
    public void actualizar( @RequestBody  ComandoConsultaMedica comandoConsultaMedica, @PathVariable Long id){
        comandoConsultaMedica.setId(id);
        manejadorActulizarConsultaMedica.ejecutar(comandoConsultaMedica);
    }
    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar consulta medica")
    public void  eliminar(@PathVariable Long id){
        manejadorEliminarConsultaMedica.ejecutar(id);
    }

}
