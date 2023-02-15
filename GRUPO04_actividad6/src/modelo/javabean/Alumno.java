package modelo.javabean;
public class Alumno extends Persona {
	private String curso;

	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String trabajar() {
		return "El alumno " 
			 + this.getNombre() 
			 + " va a estudiar para el curso " 
			 + this.curso;
	}
	
	public String hacerExamen() {
		return "El alumno " + this.getNombre() + " va a hacer su examen";
	}
	
	@Override
	public String toString() {
		return "Alumno [curso=" + curso + ", getCurso()=" + getCurso() + ", trabajar()=" + trabajar()
			 + ", hacerExamen()=" + hacerExamen() + ", getNif()=" + getNif() + ", getNombre()=" + getNombre()
			 + ", getDireccion()=" + getDireccion() + ", getTelefono()=" + getTelefono() + ", getClass()="
			 + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
