package modelo.javabean;

import java.util.Objects;

public abstract class Persona implements Comparable<Persona> {
	
	private String nif;
	private String nombre;
	private String direccion;
	private String telefono;
	
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String llamar(Persona p){
		return this.nombre + " llamando a " + p.getNombre();
	}
	
	public abstract String trabajar();
	
	@Override
	public int hashCode() {
		return Objects.hash(nif);
	}
	@Override
	public int compareTo(Persona persona) {
		return this.nombre.compareTo(persona.nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(nif.toLowerCase(), other.nif.toLowerCase());
	}
}
