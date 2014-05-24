package com.sdi.business;

/**
 * Clase que crea services y los devuelve.
 * 
 * @author UO217345
 * 
 */
public interface ServicesFactory {

	/**
	 * Crea el service correspondiente.
	 * 
	 * @return instancia del mismo.
	 */
	AsignaturasService createAsignaturasService();

	/**
	 * Crea el service correspondiente.
	 * 
	 * @return instancia del mismo.
	 */
	UsuariosService createUsuariosService();

	/**
	 * Crea el service correspondiente.
	 * 
	 * @return instancia del mismo.
	 */
	SesionService createSesionService();

}
