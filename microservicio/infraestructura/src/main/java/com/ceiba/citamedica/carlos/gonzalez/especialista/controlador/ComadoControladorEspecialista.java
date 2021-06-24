package com.ceiba.citamedica.carlos.gonzalez.especialista.controlador;

import com.ceiba.citamedica.carlos.gonzalez.ComandoRespuesta;
import com.ceiba.citamedica.carlos.gonzalez.especialista.ComandoEspecialista;
import com.ceiba.citamedica.carlos.gonzalez.especialista.comando.manejador.ManajadorEliminarEspecialista;
import com.ceiba.citamedica.carlos.gonzalez.especialista.comando.manejador.ManejadorActualizarEspecialista;
import com.ceiba.citamedica.carlos.gonzalez.especialista.comando.manejador.ManejadorCrearEspecialista;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/especialista")
@Api(tags={"Controlador comando  paciente"})
public class ComadoControladorEspecialista {
    private final ManejadorCrearEspecialista manejadorCrearEspecialista;
    private final ManejadorActualizarEspecialista manejadorActualizarEspecialista;
    private final ManajadorEliminarEspecialista manajadorEliminarEspecialista;
    
    public ComadoControladorEspecialista(ManejadorCrearEspecialista manejadorCrearEspecialista,
                                         ManejadorActualizarEspecialista manejadorActualizarEspecialista,
                                         ManajadorEliminarEspecialista manajadorEliminarEspecialista) {
        this.manejadorCrearEspecialista = manejadorCrearEspecialista;
        this.manejadorActualizarEspecialista = manejadorActualizarEspecialista;
        this.manajadorEliminarEspecialista = manajadorEliminarEspecialista;
    }
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation("Crear especialista")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoEspecialista comandoEspecialista){
        return  manejadorCrearEspecialista.ejecutar(comandoEspecialista);
    }
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @ApiOperation("Actualizar especialista")
    public void actualizar( @RequestBody  ComandoEspecialista comandoEspecialista, @PathVariable String  id){
        manejadorActualizarEspecialista.ejecutar(comandoEspecialista,id);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ApiOperation("Eliminar especialista")
    public void  eliminar(@PathVariable Long id){
        manajadorEliminarEspecialista.ejecutar(id);
    }
}
