package com.ceiba.citamedica.carlos.gonzalez.especialista.consulta;

import com.ceiba.citamedica.carlos.gonzalez.especialista.modelo.dto.DtoEspecialista;
import com.ceiba.citamedica.carlos.gonzalez.especialista.puerto.dao.DaoEspecialista;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarEspecialista {
    private final DaoEspecialista daoEspecialista;
    
    public ManejadorListarEspecialista(DaoEspecialista daoEspecialista) {
        this.daoEspecialista = daoEspecialista;
    }
    
    public List<DtoEspecialista> ejecutar(){
         return  this.daoEspecialista.listar();
     }
}
