package com.ceiba.citamedica.carlos.gonzalez.consultamedica.comando.manejador;

import com.ceiba.citamedica.carlos.gonzalez.consultamedica.modelo.entidad.ConsultaMedica;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.servicios.ServicioActulizarCitaMedica;
import com.ceiba.citamedica.carlos.gonzalez.manejador.ManejadorComando;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.ComandoConsultaMedica;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.comando.fabrica.FabricaConsultaMedica;
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
