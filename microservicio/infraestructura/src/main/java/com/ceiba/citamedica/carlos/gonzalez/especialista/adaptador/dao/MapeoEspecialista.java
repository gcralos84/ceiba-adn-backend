package com.ceiba.citamedica.carlos.gonzalez.especialista.adaptador.dao;

import com.ceiba.citamedica.carlos.gonzalez.especialista.modelo.dto.DtoEspecialista;
import com.ceiba.citamedica.carlos.gonzalez.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoEspecialista  implements RowMapper<DtoEspecialista>, MapperResult {
    @Override
    public DtoEspecialista mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id  =  resultSet.getLong("id");
        String identificacion  =  resultSet.getString("identificacion");
        String nombre = resultSet.getString("nombre");
        String  especialidad  = resultSet.getString("especialidad");
        return new DtoEspecialista(id,identificacion,nombre,especialidad);
    }
}
