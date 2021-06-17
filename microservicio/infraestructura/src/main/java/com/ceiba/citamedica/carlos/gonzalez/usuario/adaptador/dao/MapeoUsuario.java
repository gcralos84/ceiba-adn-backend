package com.ceiba.citamedica.carlos.gonzalez.usuario.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.ceiba.citamedica.carlos.gonzalez.usuario.modelo.dto.DtoUsuario;
import com.ceiba.citamedica.carlos.gonzalez.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

public class MapeoUsuario implements RowMapper<DtoUsuario>, MapperResult {

    @Override
    public DtoUsuario mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String clave = resultSet.getString("clave");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha_creacion");

        return new DtoUsuario(id,nombre,clave,fecha);
    }

}
