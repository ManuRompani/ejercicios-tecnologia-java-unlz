import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import models.Persona;
import models.Rectangulo;

public class main {

	public static void main(String[] args) {
		Consumer<String> mensaje = System.out::println;
		//Dias
		mensaje.accept("-------------------DIAS-------------------");
		List<String> dias = Stream.of("Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo").toList();
		
		dias.forEach(System.out::println);
		
		//Personas
		mensaje.accept("-------------------PERSONAS-------------------");
		List<Persona> listaPersonas = Stream.generate(() -> Persona.getRandom()).limit(60).toList();
		
		Consumer<Persona> pPerson = System.out::println;
		listaPersonas.forEach(pPerson);
		
		//Rectangulos
		mensaje.accept("-------------------RECTANGULOS-------------------");
		List<Rectangulo> listaRectangulos = Stream.generate(() -> Rectangulo.getRandom()).limit(20).toList();
		
		listaRectangulos.stream().forEach(System.out::println);
		
		listaRectangulos.forEach(r -> r.setBase(r.getBase()*2));
		mensaje.accept("-------------------BASE*2-------------------");
		listaRectangulos.stream().forEach(System.out::println);
		
		mensaje.accept("-------------------COUNT-------------------");
		// hago esto ""+... porque no se como castearlo y solo con eso ya hace todo solito
		mensaje.accept(""+listaRectangulos.stream().count());
		
	}

}
