package modelo.javabean;

public class Administrativo extends Persona {
	private String tareas;

	public Administrativo (
		String nif, 
		String nombre, 
		String direccion, 
		String telefono, 
		String tareas) 
	{
		this.setNif(nif);
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setTelefono(telefono);
		this.tareas = tareas;
	}
	
	public String getTareas() {
		return tareas;
	}
	public void setTareas(String tareas) {
		this.tareas = tareas;
	}

	@Override
	public String trabajar() {
		return "El administrativo " 
			 + this.getNombre() 
			 + "va a realizar estas tareas: " 
			 + this.tareas; 
	}
	
	public String gestionarMatricula() {
		return "El administrativo " 
			 + this.getNombre() 
			 + " va a gestionar una matrícula";
	}
	
	@Override
	public String toString() {
		return "Administrativo [tareas=" + tareas + ", getTareas()=" + getTareas() + ", trabajar()=" + trabajar()
			 + ", gestionarMatricula()=" + gestionarMatricula() + ", getNif()=" + getNif() + ", getNombre()="
			 + getNombre() + ", getDireccion()=" + getDireccion() + ", getTelefono()=" + getTelefono()
			 + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
			 + "]";
	}
}
