package mains;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import models.Persona;
import models.Rectangulo;
import utils.ComunicadorConsola;

public class MainRectangulo {

	public static void main(String[] args) {
		
		ComunicadorConsola com = new ComunicadorConsola();
		
		/*------------ PARTE 1 "GUIA STREAMS" -------------*/

		//1. Crear una lista a partir de un stream formado por los nombres de los días de la semana. 				
		List<String> listaDiasSemana = Stream.of("Lunes", "Martes", "Miercoles", "Jueves", "Viernes")
										.toList();

		com.enviar("Punto 1. Dias de la semana: ");
		com.imprimirLista(listaDiasSemana);		
		
		
		//2. Mostrar todos los rectangulos
		List<Rectangulo> listaRectangulos = Stream.generate( ()-> Rectangulo.getRandom() )
											.limit(10)
											.toList();

		com.enviar("Punto 4. Lista de rectangulos");
		com.imprimirLista(listaRectangulos);
		
		
		
		//3. Duplicar base de los rectangulos
		listaRectangulos.stream()						
						.forEach(r -> r.setBase(r.getBase()*2));
						
		com.enviar("Punto 6. Rectangulos luego de duplicar base");
		com.imprimirLista(listaRectangulos);
		
		long cantListRectangulos = listaRectangulos.stream()
									.count();
		
		com.enviar("Punto7. Imprimir cantidad de elementos en Lista Rectangulos");
		com.enviarNum((int)cantListRectangulos); 
		com.enviar("---------------------------------");
	
		
		//4. Evaluar si todos los rectángulos tienen el perímetro menor que el área.
		
		boolean perimetroIsMenorAlArea = listaRectangulos.stream()
										.allMatch(r -> ( r.getPerimetro() < r.getArea() ) );
		
		if(perimetroIsMenorAlArea) {
				com.enviar("Todos los rectangulos tienen perimetro menor que el area");
		}else {
			com.enviar("NO todos los rectangulos tienen perimetro menor que el area");
		}
		
		com.enviar("---------------------------------");
		
		//5. Evaluar si existe al menos un rectángulo donde el perímetro sea el triple de la altura.
		
		boolean perimetroTriplicaAltura = listaRectangulos.stream()
											.anyMatch(r -> r.getPerimetro() == (r.getAltura()*3 ));
		
		if(perimetroTriplicaAltura) {
			com.enviar("Existe al menos un rectangulo cuyo perimetro es el triple de su altura");
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
		
		/*--------- PARTE 2: EJERCICIOS CON OPTIONAL --------*/
		
		/*


 */
		
		com.enviar("---------------------------------");
		
		//1. Buscar el rectángulo con mayor área. 		
		Optional <Rectangulo> recMayorArea = listaRectangulos.stream()
											.max((r1, r2) -> Double.compare(r1.getArea(),r2.getArea()));
		
		recMayorArea.ifPresentOrElse(r -> com.enviar(r.toString()), () -> com.enviar("La caja esta vacia"));
						
		
		//2. Buscar el rectángulo con mayor perímetro. 
		Optional <Rectangulo> recMayorPerimetro = listaRectangulos.stream()
												.max((r1, r2) -> Double.compare(r1.getPerimetro(), r2.getPerimetro() ));
		
		recMayorPerimetro.ifPresentOrElse(r -> com.enviar(r.toString()), () -> com.enviar("La caja esta vacia"));
		
		
		//3. Obtener el primer elemento de la lista de rectangulos.
		Optional <Rectangulo> primerRDeLista = listaRectangulos.stream()
											.findFirst();
		
		primerRDeLista.ifPresentOrElse(r -> com.enviar(r.toString()), () -> com.enviar("La caja esta vacia"));
		
		com.enviar("---------------------------------");
		//4.Obtener una lista con las áreas de todos los rectángulos.
		
		Function <Rectangulo, Double> listaAreasRec = r -> r.getArea();	
													
		List<Double> listaAreasRectangulos = listaRectangulos.stream()
											.map(listaAreasRec)
											.collect(Collectors.toList());
		
		listaAreasRectangulos.stream()
		.forEach(System.out::println);
		
		com.enviar("---------------------------------");
		
		//5.Obtener una lista con la suma del área y el perímetro de cada uno de los rectángulos. 

		Function<Rectangulo, Double> toAreaPerimetro = r -> (r.getArea() + r.getPerimetro());
		
		List<Double> listaSumaAreaPerimetro = listaRectangulos.stream()
												.map(toAreaPerimetro)
												.collect(Collectors.toList());
		
		listaSumaAreaPerimetro.stream()
		.forEach(System.out::println);
		
		com.enviar("-------------Lista rectangulo base mayor altura--------------------");
		
		//6. Mostrar todos los rectángulos con base mayor a su altura. 
		
		List<Rectangulo> listaRectanguloBaseMayorAltura = listaRectangulos.stream()	
														.filter( r -> (r.getBase() > r.getAltura()) )
														.toList();
		
		listaRectanguloBaseMayorAltura.stream().forEach(System.out::println);
		
		com.enviar("--------------fin base mayor que altura-------------------");
		
		//Mostrar todos los rectángulos cuya 
		// área sea mayor a 2000 y su perímetro sea mayor al área
		com.enviar("Rectangulos de area > 2000 y perimetro mayor que area");
		List<Rectangulo> listaRecPerimetroMayorArea = listaRectangulos.stream()	
													.filter( r -> r.getArea() > 2000)
													.filter( r -> r.getPerimetro() > r.getArea())
													.toList();
		
		listaRecPerimetroMayorArea.stream().forEach(System.out::println);
		
		com.enviar("-------------fin--------------------");
	}

}
