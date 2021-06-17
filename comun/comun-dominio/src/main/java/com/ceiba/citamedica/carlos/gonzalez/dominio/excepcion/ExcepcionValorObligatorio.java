package com.ceiba.citamedica.carlos.gonzalez.dominio.excepcion;

public class ExcepcionValorObligatorio extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
    public ExcepcionValorObligatorio(String message) {
        super(message);
    }
}
