package modelo.javabean;

public class Profesor extends Persona {
	private String competencias;
	
	public String getCompetencias() {
		return competencias;
	}
	public void setCompetencias(String competencias) {
		this.competencias = competencias;
	}
	
	@Override
	public String trabajar() {
		return "El profesor " + this.getNombre() + " va a impartir su clase.";
	}
	
	public String ponerNotas() {
		return "El profesor " + this.getNombre() + " va a corregir los exámenes";
	}
	
	@Override
	public String toString() {
		return "Profesor [competencias=" + competencias + ", getCompetencias()=" + getCompetencias() + ", trabajar()="
			 + trabajar() + ", ponerNotas()=" + ponerNotas() + ", getNif()=" + getNif() + ", getNombre()="
			 + getNombre() + ", getDireccion()=" + getDireccion() + ", getTelefono()=" + getTelefono()
			 + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
			 + "]";
	}
}
