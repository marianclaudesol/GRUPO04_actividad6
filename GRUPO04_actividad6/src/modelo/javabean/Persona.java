package modelo.javabean;

public abstract class Persona {
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
}