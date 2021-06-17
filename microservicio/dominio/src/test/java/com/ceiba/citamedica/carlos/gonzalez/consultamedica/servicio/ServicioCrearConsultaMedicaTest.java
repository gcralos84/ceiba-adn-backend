package com.ceiba.citamedica.carlos.gonzalez.consultamedica.servicio;

import com.ceiba.citamedica.carlos.gonzalez.BasePrueba;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.servicio.testdatabuilder.ConsultaMedicaTestDataBuilder;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.modelo.entidad.ConsultaMedica;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.puerto.repositorio.RepositorioConsultaMedica;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.servicios.ServicioCrearConsultaMedica;
import com.ceiba.citamedica.carlos.gonzalez.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.citamedica.carlos.gonzalez.especialista.puerto.repositorio.RepositorioEspecialista;
import com.ceiba.citamedica.carlos.gonzalez.paciente.puerto.repositorio.RepositorioPaciente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

public class ServicioCrearConsultaMedicaTest {

    private  ConsultaMedica consultaMedica;
    private RepositorioEspecialista repositorioEspecialista;
    private RepositorioPaciente repositorioPaciente;
    private RepositorioConsultaMedica repositorioConsultaMedica;
    private ServicioCrearConsultaMedica servicioCrearConsultaMedica;
    private static final double DELTA = 1e-15;
    @Rule
    public ExpectedException  thrown =  ExpectedException.none();

    @Before
    public  void  setUp() {
        consultaMedica  = new ConsultaMedicaTestDataBuilder().build();
        repositorioEspecialista  = Mockito.mock(RepositorioEspecialista.class);
        repositorioPaciente  = Mockito.mock(RepositorioPaciente.class);
        repositorioConsultaMedica  = Mockito.mock(RepositorioConsultaMedica.class);
        servicioCrearConsultaMedica =
                new ServicioCrearConsultaMedica(repositorioConsultaMedica,repositorioPaciente,repositorioEspecialista);
    }
    @Test
    public void  validarSiExistePacienteTest(){
        Mockito.when(repositorioPaciente.existe(Mockito.anyString())).thenReturn(false);
        //act-assert
        BasePrueba.assertThrows(()-> servicioCrearConsultaMedica.ejecutar(consultaMedica), ExcepcionDuplicidad.class,"El paciente no esta registrado");
    }
    @Test
    public  void validarSiExisteEspecialistaTest(){
        Mockito.when(repositorioPaciente.existe(Mockito.anyString())).thenReturn(true);
        Mockito.when(repositorioEspecialista.existe(Mockito.anyString())).thenReturn(false);
        //act-assert
        BasePrueba.assertThrows(()-> servicioCrearConsultaMedica.ejecutar(consultaMedica), ExcepcionDuplicidad.class,"El especialista no esta registrado");
    }
    @Test
    public  void  calcularCuotamoderadoraUsuarioTipoITest(){
        Assert.assertEquals(3543.228, servicioCrearConsultaMedica.cuoataModeradora("TIPO_I"),DELTA);
    }
    @Test
    public  void  calcularCuotamoderadoraUsuarioTipoIITest(){
        Assert.assertEquals(13960.924, servicioCrearConsultaMedica.cuoataModeradora("TIPO_II"),DELTA);
    }
    @Test
    public void   calcularCuotamoderadoraUsuarioTipoIIITest(){
        Assert.assertEquals(37885.284, servicioCrearConsultaMedica.cuoataModeradora("TIPO_III"),DELTA);
    }
   /*@Test
    public void   calcularCuotamoderadoraUsuarioTipoIIIITest(){
        thrown.expect(ExcepcionValorInvalido.class);
        thrown.expectMessage("El tipo de usuario no es valido");
        servicioCrearConsultaMedica.cuoataModeradora("TIPO_III");
    }*/


}
