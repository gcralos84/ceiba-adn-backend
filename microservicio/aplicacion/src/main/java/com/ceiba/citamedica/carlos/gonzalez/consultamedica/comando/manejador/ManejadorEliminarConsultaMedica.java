package com.ceiba.citamedica.carlos.gonzalez.consultamedica.comando.manejador;

import com.ceiba.citamedica.carlos.gonzalez.consultamedica.servicios.ServicioEliminarCitaMedica;
import com.ceiba.citamedica.carlos.gonzalez.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarConsultaMedica  implements ManejadorComando<Long> {
    private final ServicioEliminarCitaMedica servicioEliminarCitaMedica;

    public ManejadorEliminarConsultaMedica(ServicioEliminarCitaMedica servicioEliminarCitaMedica) {
        this.servicioEliminarCitaMedica = servicioEliminarCitaMedica;
    }

    @Override
    public void ejecutar(Long comando) {
         this.servicioEliminarCitaMedica.ejecutar(comando);
    }
}
