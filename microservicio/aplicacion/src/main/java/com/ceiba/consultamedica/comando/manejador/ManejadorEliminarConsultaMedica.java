package com.ceiba.consultamedica.comando.manejador;

import com.ceiba.consultamedica.servicios.ServicioEliminarCitaMedica;
import com.ceiba.manejador.ManejadorComando;
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
