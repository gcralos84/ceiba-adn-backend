package com.ceiba.citamedica.carlos.gonzalez.usuario.consulta;

import com.ceiba.citamedica.carlos.gonzalez.usuario.modelo.dto.DtoUsuario;
import com.ceiba.citamedica.carlos.gonzalez.usuario.puerto.dao.DaoUsuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarUsuarios {
    private final DaoUsuario daoUsuario;
    public ManejadorListarUsuarios(DaoUsuario daoUsuario){
        this.daoUsuario = daoUsuario;
    }
    public List<DtoUsuario> ejecutar(){ return this.daoUsuario.listar(); }
}
