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
		
		com.enviar("Punto 2. Lista de personas ");
		com.imprimirLista(listaPersonas);
		
		//Hacer que la edad de todas las personas sea 18		
		listaPersonas.stream()
		.forEach(p -> p.setEdad(18));
		com.enviar("Punto 3. Lista de personas luego de setear edad 18");
		com.imprimirLista(listaPersonas);
		
		//Mostrar todos los rectangulos
		List<Rectangulo> listaRectangulos = Stream.generate( ()-> Rectangulo.getRandom() )
											.limit(10)
											.toList();

		com.enviar("Punto 4. Lista de rectangulos");
		com.imprimirLista(listaRectangulos);
		
		//Mostrar todas las personas
		com.enviar("Punto 5. Lista de personas");
		com.imprimirLista(listaPersonas);
		
		//Duplicar base de los rectangulos
		listaRectangulos.stream()						
						.forEach(r -> r.setBase(r.getBase()*2));
						
		com.enviar("Punto 6. Rectangulos luego de duplicar base");
		com.imprimirLista(listaRectangulos);
		
		long cantListRectangulos = listaRectangulos.stream()
									.count();
		
		com.enviar("Punto7. Imprimir cantidad de elementos en Lista Rectangulos");
		com.enviarNum((int)cantListRectangulos); 
		com.enviar("---------------------------------");
		
				
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

		
		//4. Evaluar si todos los rectángulos tienen el perímetro menor que el área.
		
		boolean perimetroIsMenorAlArea = listaRectangulos.stream()
										.allMatch(r -> ( (r.getBase()+r.getAltura())*2 < r.getArea() ) );
		
		if(perimetroIsMenorAlArea) {
				com.enviar("Todos los rectangulos tienen perimetro menor que el area");
		}else {
			com.enviar("NO todos los rectangulos tienen perimetro menor que el area");
		}
		
		com.enviar("---------------------------------");
		
		//5. Evaluar si existe al menos un rectángulo donde el perímetro sea el triple de la altura.
		
		boolean perimetroTriplicaAltura = listaRectangulos.stream()
											.anyMatch(r -> (r.getBase() + r.getAltura() )*2 > (r.getAltura()*3 ));
		
		if(perimetroTriplicaAltura) {
			com.enviar("Existe al menos un rectangulo cuyo perimetro es el triple que su altura");
		}else {
			com.enviar("NO existe al menos un rectangulo cuyo perimetro es el triple que su altura");
		}
		
		com.enviar("---------------------------------");
		
		//6. Evaluar si no existe ningún rectángulo donde el la altura sea más del doble de la base.
		boolean ningunoSuperaDobleBase = listaRectangulos.stream()
										.noneMatch(r -> r.getAltura() > r.getBase()*2);
		
		if(ningunoSuperaDobleBase) {
			com.enviar("NO existe ningun rectangulo cuya altura sea mas del doble que su base");
		}else {
			com.enviar("Existe al menos un rectangulo cuya altura supera el doble que su base");
		}
		
	}

}
