package com.ceiba.citamedica.carlos.gonzalez.consultamedica.comando.manejador;

import com.ceiba.citamedica.carlos.gonzalez.ComandoRespuesta;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.modelo.entidad.ConsultaMedica;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.servicios.ServicioCrearConsultaMedica;
import com.ceiba.citamedica.carlos.gonzalez.manejador.ManejadorComandoRespuesta;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.ComandoConsultaMedica;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.comando.fabrica.FabricaConsultaMedica;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearConsultaMedica  implements ManejadorComandoRespuesta<ComandoConsultaMedica, ComandoRespuesta<Long>> {
    private final FabricaConsultaMedica fabricaConsultaMedica;
    private final ServicioCrearConsultaMedica servicioCrearConsultaMedica;

    public ManejadorCrearConsultaMedica(FabricaConsultaMedica fabricaConsultaMedica, ServicioCrearConsultaMedica servicioCrearConsultaMedica) {
        this.fabricaConsultaMedica = fabricaConsultaMedica;
        this.servicioCrearConsultaMedica = servicioCrearConsultaMedica;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoConsultaMedica comando) {
        ConsultaMedica consultaMedica = this.fabricaConsultaMedica.crear(comando);
        return new ComandoRespuesta<>(this.servicioCrearConsultaMedica.ejecutar(consultaMedica));
    }
}
