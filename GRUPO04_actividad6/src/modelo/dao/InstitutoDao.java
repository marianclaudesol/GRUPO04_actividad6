package modelo.dao;

import java.util.List;

import modelo.javabean.Persona;

public interface InstitutoDao {
	
	//Métodos del interface
	boolean altaPersona(Persona persona);  
	Persona buscarPersona(String nif);
	List<Persona> buscarTodas();
	boolean eliminarPersona(Persona persona);	
	List<Persona> buscarPersonasPorTipo(String tipoPersona);	
}
