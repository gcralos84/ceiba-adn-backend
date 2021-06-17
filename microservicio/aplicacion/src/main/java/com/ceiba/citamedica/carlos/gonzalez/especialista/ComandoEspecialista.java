package com.ceiba.citamedica.carlos.gonzalez.especialista;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoEspecialista {
    private Long  id;
    private String identificacion;
    private String nombre;
    private String especialidad;
}
