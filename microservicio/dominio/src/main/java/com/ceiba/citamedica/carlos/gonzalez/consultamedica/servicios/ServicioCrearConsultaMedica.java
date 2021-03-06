package com.ceiba.citamedica.carlos.gonzalez.consultamedica.servicios;

import com.ceiba.citamedica.carlos.gonzalez.Mensage;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.modelo.entidad.ConsultaMedica;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.puerto.repositorio.RepositorioConsultaMedica;
import com.ceiba.citamedica.carlos.gonzalez.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.citamedica.carlos.gonzalez.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.citamedica.carlos.gonzalez.especialista.puerto.repositorio.RepositorioEspecialista;
import com.ceiba.citamedica.carlos.gonzalez.paciente.puerto.repositorio.RepositorioPaciente;

public class ServicioCrearConsultaMedica {

    private final RepositorioConsultaMedica repositorioConsultaMedica;
    private final RepositorioPaciente  repositorioPaciente;
    private final RepositorioEspecialista repositorioEspecialista;
    private  static final  double SMLDV  = 30284;
    private static final String TIPO_I = "TIPO_I";
    private static final String TIPO_II = "TIPO_II";
    private static final String TIPO_III = "TIPO_III";
    private static final Mensage EL_ESPECILISTA_NO_SE_ENCUENTRA_REGISTRADO  =  Mensage.MENSAGE_ESPECIALISTA_NO_ESTA_RESGISTRADO;
    private static final Mensage EL_PACIENTE_NO_ESTA_REGISTRADO  =  Mensage.MENSAGE_PACIENTE_NO_ESTA_RESGISTRADO;
    private static final Mensage El_TIPO_USUARIO_NO_ES_VALIDO = Mensage.TIPO_USUARIO_NO_VALIDO;
    
    public ServicioCrearConsultaMedica(RepositorioConsultaMedica repositorioConsultaMedica,
                                       RepositorioPaciente repositorioPaciente,
                                       RepositorioEspecialista repositorioEspecialista) {
        
        this.repositorioConsultaMedica = repositorioConsultaMedica;
        this.repositorioPaciente = repositorioPaciente;
        this.repositorioEspecialista = repositorioEspecialista;
    }
    public Long ejecutar(ConsultaMedica consultamMedica){
        validarExistenciaPaciente(consultamMedica);
        validarExistenciaEspecialista(consultamMedica);
        consultamMedica.setValorCuotaModeradora(cuoataModeradora(consultamMedica.getTipoUsuario()));
        return this.repositorioConsultaMedica.crear(consultamMedica);
    }

    private void validarExistenciaPaciente(ConsultaMedica consultamMedica) {
        boolean  existe = repositorioPaciente.existe(consultamMedica.getIdentificacionPaciente());
        if(!existe)
            throw  new ExcepcionDuplicidad(EL_PACIENTE_NO_ESTA_REGISTRADO.getMensage());
    }
    
    private void validarExistenciaEspecialista(ConsultaMedica consultamMedica) {
         boolean existe =  this.repositorioEspecialista.existe(consultamMedica.getIdentificacionEspecialista());
         if(!existe)
             throw new ExcepcionDuplicidad(EL_ESPECILISTA_NO_SE_ENCUENTRA_REGISTRADO.getMensage());
    }
    public   double  cuoataModeradora(String  tipoUsuario){

        double montoCuoataModeradora = 0;
           switch (tipoUsuario){
               case TIPO_I:
                   montoCuoataModeradora = SMLDV*0.1170;
                   break;
               case TIPO_II:
                   montoCuoataModeradora = SMLDV*0.4610;
                   break;
               case  TIPO_III:
                   montoCuoataModeradora = SMLDV*1.251;
                   break;
               default:
                    throw  new ExcepcionValorInvalido(El_TIPO_USUARIO_NO_ES_VALIDO.getMensage());
           }
        return montoCuoataModeradora;
    }
}
