package com.ceiba.especialista.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoEspecialista {
    private Long  id;
    private String identificacion;
    private String nombre;
    private String especialista;
}
