package com.ceiba.consultamedica.comando.manejador;

import com.ceiba.consultamedica.ComandoConsultaMedica;
import com.ceiba.consultamedica.comando.fabrica.FabricaConsultaMedica;
import com.ceiba.consultamedica.modelo.entidad.ConsultaMedica;
import com.ceiba.consultamedica.servicios.ServicioActulizarCitaMedica;
import com.ceiba.consultamedica.servicios.ServicioEliminarCitaMedica;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActulizarConsultaMedica  implements ManejadorComando<ComandoConsultaMedica> {
    private final FabricaConsultaMedica  fabricaConsultaMedica;
    private final ServicioActulizarCitaMedica servicioActulizarCitaMedica;

    public ManejadorActulizarConsultaMedica(FabricaConsultaMedica fabricaConsultaMedica, ServicioActulizarCitaMedica servicioActulizarCitaMedica) {
        this.fabricaConsultaMedica = fabricaConsultaMedica;
        this.servicioActulizarCitaMedica = servicioActulizarCitaMedica;
    }

    @Override
    public void ejecutar(ComandoConsultaMedica comando) {
        ConsultaMedica consultaMedica =  this.fabricaConsultaMedica.crear(comando);
        this.servicioActulizarCitaMedica.ejecutar(consultaMedica);
    }
}
