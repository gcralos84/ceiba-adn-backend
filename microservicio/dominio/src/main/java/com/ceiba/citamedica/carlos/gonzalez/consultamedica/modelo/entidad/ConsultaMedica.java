package com.ceiba.citamedica.carlos.gonzalez.consultamedica.modelo.entidad;

import com.ceiba.citamedica.carlos.gonzalez.Mensage;
import lombok.Getter;

import java.time.LocalDate;

import static com.ceiba.citamedica.carlos.gonzalez.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class ConsultaMedica {
    private static final  Mensage SE_DEBE_INGRESAR_INFORMACION_ESPECILISTA = Mensage.MENSAGE_INFORMACION_ESPECIALISTA_REQUERIDO;
    private static final  Mensage SE_DEBE_INGRESAR_INFORMACION_PACIENTE = Mensage.MENSAGE_INFORMACION_PACIENTE_REQUERIDO;;
    private static final  Mensage SE_DEBE_INGRESAR_LA_FECHA_CITA  = Mensage.MENSAGE_FECHA_CITA__REQUERIDO;
    private static final  Mensage SE_DEBE_INGRESAR_EL_TIPO_USUARIO  = Mensage.MENSAGE_TIPO_USUARIO_REQUERIDO;

    private Long  id;
    private String identificacionEspecialista;
    private String identificacionPaciente;
    private LocalDate fechaCita;
    private String tipoUsuario;
    private double valorCuotaModeradora;
    
    public ConsultaMedica(Long id, String identificacionEspecialista, String identificacionPaciente,String tipoUsuario, LocalDate fechaCita) {
        validarObligatorio(identificacionEspecialista,SE_DEBE_INGRESAR_INFORMACION_ESPECILISTA.getMensage());
        validarObligatorio(identificacionPaciente,SE_DEBE_INGRESAR_INFORMACION_PACIENTE.getMensage());
        validarObligatorio(tipoUsuario,SE_DEBE_INGRESAR_EL_TIPO_USUARIO.getMensage());
        validarObligatorio(fechaCita,SE_DEBE_INGRESAR_LA_FECHA_CITA.getMensage());
        
        this.id = id;
        this.identificacionEspecialista = identificacionEspecialista;
        this.identificacionPaciente = identificacionPaciente;
        this.fechaCita = fechaCita;
        this.tipoUsuario = tipoUsuario;
    }

    public void setValorCuotaModeradora(double valorCuotaModeradora) {
        this.valorCuotaModeradora = valorCuotaModeradora;
    }
}
