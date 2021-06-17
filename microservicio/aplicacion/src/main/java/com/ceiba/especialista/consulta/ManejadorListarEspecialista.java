package com.ceiba.especialista.consulta;

import com.ceiba.especialista.modelo.dto.DtoEspecialista;
import com.ceiba.especialista.puerto.dao.DaoEspecialista;
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
