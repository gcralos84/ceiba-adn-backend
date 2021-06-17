package com.ceiba.consultamedica.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.consultamedica.ComandoConsultaMedica;
import com.ceiba.consultamedica.comando.fabrica.FabricaConsultaMedica;
import com.ceiba.consultamedica.modelo.entidad.ConsultaMedica;
import com.ceiba.consultamedica.servicios.ServicioCrearConsultaMedica;
import com.ceiba.manejador.ManejadorComandoRespuesta;
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
