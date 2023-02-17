package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import modelo.javabean.Administrativo;
import modelo.javabean.Alumno;
import modelo.javabean.Persona;
import modelo.javabean.Profesor;

public class Instituto implements InstitutoDao{
	private ArrayList<Persona> personas;
	
	public Instituto() {
		personas = new ArrayList<Persona>();
	}
	
	@Override
	public boolean altaPersona(Persona persona) {
		if (persona == null || 
			persona.getNif() == null || 
			persona.getNif().isEmpty() ||
			persona.getNif().isBlank() ||
			personas.contains(persona))	
			return false;						
		else
			return personas.add(persona); 
	}

	@Override
	public Persona buscarPersona(String nif) {
		int index = 0;
		Persona personaEncontrada = null;
		while (personaEncontrada == null && index < personas.size()) {
			Persona persona = personas.get(index);
			if(persona.getNif() == nif) {
				personaEncontrada = persona;
			}
			index++;
		}
		return personaEncontrada;
	}
	
	@Override
	public List<Persona> buscarTodas() {
		return personas;
	}

	@Override
	public boolean eliminarPersona(Persona persona) {
		if (persona == null || 
			persona.getNif() == null || 
			persona.getNif().isEmpty() ||
			persona.getNif().isBlank())	
			return false;
		
		return personas.remove(persona); 
	}

	@Override
	public List<Persona> buscarPersonasPorTipo(String tipoPersona) {
		List<Persona> resultado = new ArrayList<Persona>();
		
		if (tipoPersona == null || 
			tipoPersona.isEmpty() ||
			tipoPersona.isBlank())	
			return resultado;
		
		for (int index = 0; index < personas.size(); index++) {
			Persona persona = personas.get(index);
			switch(tipoPersona) {
				case "Alumno":
					if (persona instanceof Alumno) {
						resultado.add(persona);
					}
					break;
				case "Profesor":
					if (persona instanceof Profesor) {
						resultado.add(persona);
					}
					break;
				case "Administrativo":
					if (persona instanceof Administrativo) {
						resultado.add(persona);
					}
					break;
			}
		}
		return resultado;
	}
}