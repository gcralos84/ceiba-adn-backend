package com.ceiba.citamedica.carlos.gonzalez.consultamedica.modelo.entidad;

import com.ceiba.citamedica.carlos.gonzalez.Mensage;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.ceiba.citamedica.carlos.gonzalez.dominio.ValidadorArgumento.*;

@Getter
public class ConsultaMedica {
    private static final Mensage SE_DEBE_INGRESAR_INFORMACION_ESPECILISTA = Mensage.MENSAGE_INFORMACION_ESPECIALISTA_REQUERIDO;
    private static final Mensage SE_DEBE_INGRESAR_INFORMACION_PACIENTE = Mensage.MENSAGE_INFORMACION_PACIENTE_REQUERIDO;
    private static final Mensage SE_DEBE_INGRESAR_LA_FECHA_CITA  = Mensage.MENSAGE_FECHA_CITA__REQUERIDO;
    private static final Mensage SE_DEBE_INGRESAR_EL_TIPO_USUARIO  = Mensage.MENSAGE_TIPO_USUARIO_REQUERIDO;
    private static final Mensage FECHA_NO_VALIDAD  = Mensage.MENSAGE_FECHA_CITA_IVALIDAD;
    private static final Mensage FECHA_DEVE_SER_POSTERIOR_A_LA_FECHA_ACTUAL  = Mensage.MENSAGE_FECHA_CITA_IVALIDAD_POSTERIOR_AL_DIA_ACTUAL;
    private static final Mensage HORA_NO_VALIDAD  = Mensage.MENSAGE_HORA_CITA_IVALIDAD;
    
    private Long  id;
    private String identificacionEspecialista;
    private String identificacionPaciente;
    private LocalTime horaCita;
    private LocalDate fechaCita;
    private String tipoUsuario;
    private double cuoataModeradora;
    private Boolean active;
    
    public ConsultaMedica(Long id, String identificacionEspecialista, String identificacionPaciente,
                          LocalTime horaCita,LocalDate fechaCita,String tipoUsuario, Boolean active) {
        
        validarObligatorio(identificacionEspecialista,SE_DEBE_INGRESAR_INFORMACION_ESPECILISTA.getMensage());
        validarObligatorio(identificacionPaciente,SE_DEBE_INGRESAR_INFORMACION_PACIENTE.getMensage());
        validarObligatorio(tipoUsuario,SE_DEBE_INGRESAR_EL_TIPO_USUARIO.getMensage());
        validarObligatorio(fechaCita,SE_DEBE_INGRESAR_LA_FECHA_CITA.getMensage());
        validarHoracita(horaCita, HORA_NO_VALIDAD.getMensage());
        validarFechaCitaMedica(fechaCita,FECHA_NO_VALIDAD.getMensage());
        validarFechaDiaVencido(fechaCita,FECHA_DEVE_SER_POSTERIOR_A_LA_FECHA_ACTUAL.getMensage());
        this.id = id;
        this.identificacionEspecialista = identificacionEspecialista;
        this.identificacionPaciente = identificacionPaciente;
        this.horaCita =horaCita;
        this.fechaCita = fechaCita;
        this.tipoUsuario = tipoUsuario;
        this.active = active;
    }

    public void setValorCuotaModeradora(double valorCuotaModeradora) {
        this.cuoataModeradora = valorCuotaModeradora;
    }
}
