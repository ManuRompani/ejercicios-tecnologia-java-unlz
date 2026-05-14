package mains;
import models.Persona;
import models.Rectangulo;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import utils.ComunicadorConsola;

public class MainPersona {
	public static void main(String[] args) {
		ComunicadorConsola com = new ComunicadorConsola();

		//Guardar una lista con 60 personas aleatorias en una variable llamada listaPersonas. 		
		List<Persona> listaPersonas = Stream.generate( ()-> Persona.getRandom() )
				.limit(10) //Puse 10 porque me explota la compu jajaja
				.toList();
		
		com.enviar("Punto 2. Lista de personas ");
		com.imprimirLista(listaPersonas);
		
		//Hacer que la edad de todas las personas sea 18		
		/*listaPersonas.stream()
		.forEach(p -> p.setEdad(18));
		com.enviar("Punto 3. Lista de personas luego de setear edad 18");
		com.imprimirLista(listaPersonas);
		*/
		
		//Mostrar todas las personas
		com.enviar("Punto 5. Lista de personas");
		com.imprimirLista(listaPersonas);
		
		
		//1. Evaluar si todas las personas son mayores a los 20 años. 
		boolean sonMayoresA20 = listaPersonas.stream()
		.allMatch(p -> p.getEdad() > 20);
		
		if(sonMayoresA20) {
			com.enviar("Todas las personas son mayores a 20");
		}else {
			com.enviar("NO TODOS son mayores a 20");
		}		
		com.enviar("---------------------------------");

		
		//2. Evaluar si existe al menos una persona de más de 1.95 cm.
		boolean hayPersonasAltas = listaPersonas.stream()
								.anyMatch(p -> p.getEstatura() > 1.95);
		
		if(hayPersonasAltas) {
			com.enviar("Existe una persona super alta");
		}else {
			com.enviar("NO HAY al menos una persona gigante");
		}		
		com.enviar("---------------------------------");

		
		//3. Evaluar si no existe ninguna que su nombre empiece con R.
		
		boolean noExisteNombreConR = listaPersonas.stream()
								.noneMatch(p -> p.getNombre().charAt(0) == 'R');
		
		if(noExisteNombreConR) {
			com.enviar("NO existe ninguna persona que comience su nombre con R");
		}else {
			com.enviar("Existe una persona cuyo nombre empieza con R");		
			}	
		com.enviar("---------------------------------");

		
		/*--------- PARTE 2: EJERCICIOS CON OPTIONAL --------*/
		
		//2. Buscar la persona con menor edad. 
		
		Optional<Persona> personaMenorEdad = listaPersonas.stream()
											.min((p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad()));
		
		personaMenorEdad.ifPresentOrElse(p -> com.enviar( p.toString() ), () -> com.enviar("La caja esta vacia") );	
		com.enviar("---------------------------------");

		//1. Obtener una lista con solo los nombres de las personas (Puede repetir)
		
		Function <Persona, String> nombrePersona = p -> p.getNombre();
		
		List<String> listaPersonasNombre = listaPersonas.stream()
											.map(nombrePersona)
											.toList();
		
		com.enviar("Lista de nombres de Personas");
		listaPersonasNombre.stream()
		.forEach(System.out::println);		
		com.enviar("---------------------------------");

		// Obtener una lista con todas las personas 
		//convertidas en rectángulos siendo su altura: la estatura de la 
		//persona * 50 y la base: el peso de la persona. 
	
		
		Function<Persona, Rectangulo> transformarPersonaEnRectangulo = p -> {
																	double altura = p.getEstatura() * 50;
																	double base = p.getPeso();
																	String nombre = p.getNombre();
																	return new Rectangulo(nombre, base, altura);
																			};
		List<Rectangulo> listaPersonasTransformadas = listaPersonas.stream()
													.map(transformarPersonaEnRectangulo)
													.toList();
		
	
		com.enviar("Personas transformadas en rectangulos");
		listaPersonasTransformadas.stream().forEach(System.out::println);		
		com.enviar("---------------------------------");
		
		//Obtener una lista con la suma del área 
		//y el perímetro de cada una de las personas (Si fueran rectángulos).
		// estatura -> altura 
		// peso -> base
		// perimetro -> 2 * (base + altura)
		// are -> base*altura
		
		Function<Persona, Double> sumaArea = p -> {
			double altura = p.getEstatura();
			double base = p.getPeso();
			double perimetro = 2* (base + altura);
			double area = base * altura; 
			
			return area + perimetro; 
		};
		
		List<Double> sumaAreaPerimetroPersonasRectangulos = listaPersonas.stream()				
				.map(sumaArea)
				.toList();
		
		sumaAreaPerimetroPersonasRectangulos.stream().forEach(System.out::println);
		listaPersonas.stream().forEach(System.out::println);
		com.enviar("---------------------------------");
	
		//Incrementar en 0.4 la estatura de todas las personas que midan menos de 1.4
		
		Function <Persona, Persona> incrementarEstatura = p -> {
			double nuevaEstatura = p.getEstatura() + 1;
			p.setEstatura(nuevaEstatura);
			return p;			
		};
		
		List<Persona> listaPersonasEstaturaNueva = listaPersonas.stream()
					.filter(p -> (p.getEstatura() < 0.4))
					.map(incrementarEstatura)
					.toList();
		
		
		listaPersonas.stream()
		.forEach(System.out::println);
				
		com.enviar("---------------------------------");

		// Encontrar a la persona más alta de las que tengan menos de 40 años. 
		
		Optional<Persona> personaAltaJoven = listaPersonas.stream()
											.filter( p -> p.getEdad() < 40)
											.max( (p1, p2) -> Double.compare(p1.getEstatura(), p2.getEstatura()) );
		personaAltaJoven.ifPresentOrElse(System.out::println,()-> com.enviar("La caja esta vacia" ));
		
		com.enviar("---------------------------------");
		
		//Encontrar a la persona más baja que cuyo nombre empiece con J. 
		
		Optional<Persona> personaBajaConJ = listaPersonas.stream()
											.filter( p -> p.getNombre().charAt(0) == 'J' || p.getNombre().charAt(0) == 'j')
											.min( (p1, p2) -> Double.compare(p1.getEstatura(), p2.getEstatura()));
		
		personaBajaConJ.ifPresentOrElse( System.out::println, () -> com.enviar("La caja esta vacia" ) );
		
		
			}
		}
