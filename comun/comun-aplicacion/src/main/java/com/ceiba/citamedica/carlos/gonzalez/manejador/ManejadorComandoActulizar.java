package com.ceiba.citamedica.carlos.gonzalez.manejador;

import org.springframework.transaction.annotation.Transactional;

public interface ManejadorComandoActulizar<C,I>{
    
    @Transactional
    void ejecutar(C comando, I id);
}
