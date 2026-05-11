package mains;

import java.util.List;
import java.util.stream.Stream;

import models.Persona;
import models.Rectangulo;
import utils.ComunicadorConsola;

public class Main {

	public static void main(String[] args) {
		
		ComunicadorConsola com = new ComunicadorConsola();

		//Crear una lista a partir de un stream formado por los nombres de los días de la semana. 				
		List<String> listaDiasSemana = Stream.of("Lunes", "Martes", "Miercoles", "Jueves", "Viernes")
										.toList();

		com.enviar("Punto 1. Dias de la semana: ");
		com.imprimirLista(listaDiasSemana);
		
		//Guardar una lista con 60 personas aleatorias en una variable llamada listaPersonas. 		
		List<Persona> listaPersonas = Stream.generate( ()-> Persona.getRandom() )
				.limit(10) //Puse 10 porque me explota la compu jajaja
				.toList();
		
		System.out.println("Punto 2. Lista de personas ");
		com.imprimirLista(listaPersonas);
		
		//Hacer que la edad de todas las personas sea 18		
		listaPersonas.stream()
		.forEach(p -> p.setEdad(18));
		System.out.println("Punto 3. Lista de personas edad 18");
		com.imprimirLista(listaPersonas);
		
		//Mostrar todos los rectangulos
		List<Rectangulo> listaRectangulos = Stream.generate( ()-> Rectangulo.getRandom() )
											.limit(10)
											.toList();
		System.out.println("Punto 4. Lista de rectangulos");
		com.imprimirLista(listaRectangulos);
		
		//Mostrar todas las personas
		System.out.println("Punto 5. Lista de personas");
		com.imprimirLista(listaPersonas);
		
		//Duplicar base de los rectangulos
		listaRectangulos.stream()						
						.forEach(r -> r.setBase(r.getBase()*2));
						
		System.out.println("Punto 6. Rectangulos con base duplicada");
		com.imprimirLista(listaRectangulos);
		
	}

}
