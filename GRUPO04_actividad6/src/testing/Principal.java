package testing;

import java.util.ArrayList;
import java.util.List;

import modelo.dao.Instituto;
import modelo.dao.InstitutoDao;
import modelo.javabean.Administrativo;
import modelo.javabean.Alumno;
import modelo.javabean.Persona;
import modelo.javabean.Profesor;

public class Principal {

	public static void main(String[] args) {
						
		Profesor prof1 = new Profesor("51663211R", "Carlos Robles", 
									  "C/ Pez Volador, 35", "645425864",
									  "Matemáticas y Lengua");
		Alumno alum1 = new Alumno("53222441A", "Alicia Torres",
								  "C/ Luna Lunera, 45", "606570589", 
								  "1º Bachillerato");
		Administrativo admin1= new Administrativo("25062022Z", "Maria Fernandez",
												  "Calle Julia Novoa 4", "627058529",
												  "Gestionar Matrículas, controlar asistencia"); 

	    System.out.println("Pruebas de Clases:");
		System.out.println();
		
	    //Ejecuta el método toString() sobre cada tipo de clase
		System.out.println(prof1.toString());
		System.out.println(alum1.toString());
		System.out.println(admin1.toString());
		System.out.println();
		
	    //Ejecuta el método trabajar() sobre cada tipo de clase
		System.out.println(prof1.trabajar());
		System.out.println(alum1.trabajar());
		System.out.println(admin1.trabajar());
		System.out.println();
		
		//Ejecuta el método llamar(Persona p) para que el alumno llame al profesor
	    System.out.println(alum1.llamar(prof1));
	    System.out.println();
	    
	    //Ejecuta el método ponerNotas() del objeto Profesor
	    System.out.println(prof1.ponerNotas());
	    System.out.println();
	    
	    //Ejecuta el método hacerExamen() del objeto Alumno
	    System.out.println(alum1.hacerExamen());
	    System.out.println();
	    
	    //Ejecuta el método gestionarMatricula() del objeto Administrativo
	    System.out.println(admin1.gestionarMatricula());
	    System.out.println();
	    

		//Creamos instancia Instituto
		InstitutoDao miInstituto = new Instituto(); 
		
		List<Persona> aspirantes = generarAspirantes();

	    System.out.println("Pruebas de Instituto:");
		System.out.println();
		testDarAlta(miInstituto, aspirantes);

		testBuscarPorNif(miInstituto);
		
		testBuscarTodas(miInstituto);
		
		testEliminar(miInstituto);
		
		testBuscarPorTipo(miInstituto);
	}

	private static List<Persona> generarAspirantes(){
		List<Persona> aspirantes = new ArrayList<Persona>();
		aspirantes.add(
			new Alumno("72659485A", "Alejandro Pérez",
					   "C/ Quinto pino, 52" , "618952304",
					   "4º ESO"));
		aspirantes.add(
			new Alumno("12345678Z", "Blanca González",
					   "C/ Altamira, 25" , "657893215",
					   "2º ESO"));
		aspirantes.add(
			new Alumno("12345678Z", "Lluc González",
					   "C/ Altamira, 25" , "666556677",
					   "2º ESO"));
		aspirantes.add(
			new Profesor("91684238R", "Armando Paredes",
					     "C/ Serrano,111" , "625843601", 
					     "Geografía"));
		aspirantes.add(
			new Profesor("85165472R", "Ángel García", 
					     "C/ Serrano,333" , "685412950", 
					     "Matemáticas"));
		aspirantes.add(
			new Profesor("85165472R", "Luís García", 
						 "C/ Serrano,333" , "676898745", 
						 "Matemáticas"));
		aspirantes.add(
			new Administrativo("94683159L", "Aitor Tilla", 
							   "C/ Madroño", "615876328", 
							   "Gestionar Matrículas, controlar asistencia"));
		aspirantes.add(
			new Administrativo("87654321Z", "Maria del Mar Fernández", 
							   "C/ Toni Vadell,3", "666554433", 
							   "Pasar recibos comedor, Hacer inventario"));
		aspirantes.add(
			new Administrativo("87654321Z", "Xisca Fernández", 
							   "C/ Toni Vadell,3", "633567890", 
							   "Pasar recibos comedor, Hacer inventario"));
		return aspirantes;
	}

	/**
	 * Damos de alta a los aspirantes en el orden de inscripción.
	 * @param miInstituto
	 * @param aspirantes
	 */
	private static void testDarAlta(InstitutoDao miInstituto, List<Persona> aspirantes) {
		System.out.println("Intento de alta con Persona null: " 
			+ miInstituto.altaPersona(null));
		System.out.println("Intento de alta con valores de Persona null: " 
			+ miInstituto.altaPersona(new Alumno(null, null, null, null, null)));
		System.out.println("Intento de alta con valores de Persona vacío: " 
			+ miInstituto.altaPersona(new Alumno("", "", "", "", "")));
		System.out.println("Intento de alta con valores de Persona espacios: " 
			+ miInstituto.altaPersona(new Alumno(" ", " ", " ", " ", " ")));
		System.out.println();
		for(Persona aspirante: aspirantes) {
			if (miInstituto.altaPersona(aspirante)) {
				System.out.println(aspirante.getNombre() + " se ha dado de alta.");
			}else {
				Persona existente = miInstituto.buscarPersona(aspirante.getNif());
				System.out.println("Ya existe "+ existente.getNombre() +" con el NIF " + aspirante.getNif() 
								+  ", por lo que " + aspirante.getNombre() + " no se ha dado de alta.");
			}
		}
	}
	
	/**
	 * Pruebas de búsqueda por NIF
	 * @param miInstituto
	 */
	private static void testBuscarPorNif(InstitutoDao miInstituto) {
		InstitutoDao institutoVacio = new Instituto();

		System.out.println();
		System.out.println("Resultado de buscar en instituto vacío: "
			+ institutoVacio.buscarPersona("12345678Z"));
		System.out.println("Resultado de buscar con NIF null: "
			+ miInstituto.buscarPersona(null));
		System.out.println("Resultado de buscar con NIF vacío: "
			+ miInstituto.buscarPersona(""));
		System.out.println("Resultado de buscar con NIF de espacios: "
			+ miInstituto.buscarPersona("   "));
		System.out.println("Resultado de buscar con NIF que no existe: "
			+ miInstituto.buscarPersona("12345678A"));
		System.out.println("Resultado de buscar con NIF que si existe: "
			+ miInstituto.buscarPersona("12345678Z"));
	}
	
	/**
	 * Pruebas de consulta de todas las personas
	 * @param miInstituto
	 */
	private static void testBuscarTodas(InstitutoDao miInstituto) {
		InstitutoDao institutoVacio = new Instituto();
		
		System.out.println();
		System.out.println("Resultado de buscar Todas en instituto vacío: "
			+ institutoVacio.buscarTodas());
		System.out.println("Resultado de buscar Todas en mi instituto: ");
		for(Persona persona: miInstituto.buscarTodas()) {
			System.out.println(">>> " + persona);
		}
	}
	
	/**
	 * Pruebas de consulta de todas las personas
	 * @param miInstituto
	 */
	private static void testEliminar(InstitutoDao miInstituto) {
		InstitutoDao institutoVacio = new Instituto();

		System.out.println();
		System.out.println("Intento de eliminar con Persona null: " 
			+ miInstituto.eliminarPersona(null));
		System.out.println("Intento de eliminar con valores de Persona null: " 
			+ miInstituto.eliminarPersona(new Alumno(null, null, null, null, null)));
		System.out.println("Intento de eliminar con valores de Persona vacío: " 
			+ miInstituto.eliminarPersona(new Alumno("", "", "", "", "")));
		System.out.println("Intento de eliminar con valores de Persona espacios: " 
			+ miInstituto.eliminarPersona(new Alumno(" ", " ", " ", " ", " ")));
		System.out.println("Intento de eliminar Persona que no existe: " 
			+ miInstituto.eliminarPersona(new Alumno("testNif", "testNombre",
													 "testDirección" , "testTeléfono",
													 "testCurso")));
		
		Persona personaExistente = miInstituto.buscarPersona("12345678Z");
		System.out.println("Intento de eliminar Persona que si existe con NIF: "
			+ personaExistente.getNif()
			+ " " 
			+ miInstituto.eliminarPersona(personaExistente));
		System.out.println("Intento de eliminar Persona en instituto vacío: " 
			+ institutoVacio.eliminarPersona(personaExistente));
	}
	
	/**
	 * Pruebas de búsqueda por tipo
	 * @param miInstituto
	 */
	private static void testBuscarPorTipo(InstitutoDao miInstituto) {
		InstitutoDao institutoVacio = new Instituto();
		System.out.println();	
		System.out.println("Intento de lista en instituto vacío:"
						 + institutoVacio.buscarPersonasPorTipo("Alumno"));		
		System.out.println("Intento de lista con parámetro null: "
				  		 + miInstituto.buscarPersonasPorTipo(null));	
		System.out.println("Intento de lista con parámetro vacío: "
						 + miInstituto.buscarPersonasPorTipo(""));
		System.out.println("Intento de lista con parámetro de espacios: "
						 + miInstituto.buscarPersonasPorTipo("  "));
		System.out.println("Intento de lista con tipo inexistente (Director): "
						 + miInstituto.buscarPersonasPorTipo("Director"));
		//Solo aparece un alumno porque hemos hecho el test de eliminar
		System.out.println("Intento de lista con tipo existente (Alumno): ");
		for(Persona persona: miInstituto.buscarPersonasPorTipo("Alumno")) {
			System.out.println(">>> " + persona);
		}
		System.out.println("Intento de lista con tipo existente (Profesor): ");
		for(Persona persona: miInstituto.buscarPersonasPorTipo("Profesor")) {
			System.out.println(">>> " + persona);
		}
		System.out.println("Intento de lista con tipo existente (Administrativo): ");
		for(Persona persona: miInstituto.buscarPersonasPorTipo("Administrativo")) {
			System.out.println(">>> " + persona);
		}
	}
}
