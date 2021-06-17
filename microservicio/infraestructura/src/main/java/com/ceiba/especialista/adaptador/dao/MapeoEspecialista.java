package com.ceiba.especialista.adaptador.dao;

import com.ceiba.especialista.modelo.dto.DtoEspecialista;
import com.ceiba.infraestructura.jdbc.MapperResult;
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
