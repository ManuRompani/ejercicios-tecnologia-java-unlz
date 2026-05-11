package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Randomizador {

	private List<String> nombres;
	private List<String> apellidos;

	public Randomizador() {
		this.apellidos = Arrays.asList(
	            "González", "Rodríguez", "López", "Fernández", "Pérez", "García", "Martínez", "Sánchez", "Romero", "Díaz",
	            "Torres", "Vázquez", "Castro", "Suárez", "Ramos", "Giménez", "Herrera", "Domínguez", "Moreno", "Flores",
	            "Chávez", "Molina", "Ortega", "Silva", "Delgado", "Cabrera", "Rojas", "Acosta", "Méndez", "Aguilar",
	            "Cruz", "Paredes", "Vargas", "Salazar", "Arias", "Ponce", "Alvarez", "Benítez", "Carrasco", "Cortés",
	            "Espinoza", "Ibarra", "Montoya", "Peña", "Ríos", "Valdez", "Vera", "Muñoz", "Escobar", "Figueroa", "Miranda",
	            "Campos", "Navarro", "Quintero", "Rivera", "Soto", "Mejía", "Burgos", "Luna", "Morales", "Mendoza",
	            "Reyes", "Guzmán", "Serrano", "Vega", "Barrios", "Blanco", "Palacios", "Zambrano", "Cisneros", "Ortiz",
	            "Pacheco", "Fuentes", "Maldonado", "Bravo", "Esquivel", "Peralta", "Solís", "Cáceres", "Villalba", "Caballero",
	            "Santana", "Quiroga", "Tapia", "Alvarado", "Bustos", "Ferrari", "Lagos", "Cordero", "Montes", "Reynoso",
	            "Durán", "Vallejo", "Arroyo", "Soria", "Villanueva", "Medina", "Parra", "Riquelme", "Arce", "Escalante",
	            "Orozco", "Paredes", "Zúñiga", "Segovia", "Téllez", "Pinto", "Guerra", "Montero", "Mora", "Roldán",
	            "Farfán", "Barrera", "Carrillo", "Cárdenas", "Contreras", "Cordero", "Arroyo", "Aguirre", "Avendaño", "Galindo",
	            "Valencia", "Valverde", "Garay", "Alonso", "Montiel", "Sáenz", "Prado", "Marrero", "Venegas", "Portillo",
	            "Toledo", "Barragán", "Bermúdez", "Delgado", "Cano", "Cuevas", "Andrade", "Valladares", "Nieto", "Escobedo",
	            "Fonseca", "Chacón", "Tovar", "Espinosa", "Amaya", "Cuellar", "Reyna", "Guerrero", "Navarrete", "Pizarro",
	            "Rincón", "Sandoval", "Tejada", "Padilla", "Leiva", "López", "Jiménez", "Oliva", "Ramírez", "Ferrer",
	            "Almeida", "Barros", "Campos", "Godoy", "Izquierdo", "Jacinto", "Monzón", "Ojeda", "Perdomo", "Rivas"
	        );

		this.nombres = Arrays.asList("Alejandro", "Bruno", "Carlos", "Daniel", "Emilio", "Fernando", "Gabriel", "Hugo",
				"Iván", "Javier", "Kurt", "Luis", "Manuel", "Nicolás", "Oscar", "Pablo", "Quintín", "Ramiro", "Sergio",
				"Tomás", "Ulises", "Vicente", "Walter", "Xavier", "Yago", "Zacarías", "Adrián", "Bernardo", "César",
				"Diego", "Eduardo", "Fabián", "Gustavo", "Héctor", "Ignacio", "Jorge", "Kevin", "Leandro", "Mariano",
				"Néstor", "Octavio", "Pedro", "Roberto", "Santiago", "Tobías", "Uriel", "Víctor", "William", "Ximeno",
				"Yahir", "Alfonso", "Bautista", "Cristian", "David", "Ezequiel", "Federico", "Gerardo", "Hernán",
				"Iker", "Julio", "Kilian", "Leonardo", "Matías", "Nahuel", "Omar", "Patricio", "Rafael", "Sebastián",
				"Thiago", "Valentín", "Andrés", "Brayan", "Claudio", "Darío", "Esteban", "Facundo", "Guillermo",
				"Homero", "Ismael", "Jonathan", "Lucas", "Mauricio", "Nelson", "Orlando", "Pascual", "Ricardo", "Simón",
				"Teodoro", "Vladimir", "Yamil", "Ana", "Bárbara", "Camila", "Diana", "Elena", "Florencia", "Gabriela",
				"Helena", "Isabel", "Julia", "Karla", "Laura", "María", "Natalia", "Olga", "Patricia", "Raquel", "Sara",
				"Tatiana", "Úrsula", "Valeria", "Wendy", "Ximena", "Yolanda", "Zulema", "Adriana", "Belén", "Carla",
				"Daniela", "Elisa", "Fernanda", "Graciela", "Hilda", "Ivana", "Jessica", "Karina", "Lorena", "Mónica",
				"Nuria", "Ofelia", "Paola", "Rocío", "Silvia", "Teresa", "Verónica", "Yadira", "Zaira", "Alba",
				"Blanca", "Carolina", "Dolores", "Estefanía", "Fiorella", "Gloria", "Haydée", "Inés", "Jimena",
				"Katherine", "Luz", "Magdalena", "Noelia", "Oriana", "Pilar", "Rita", "Sofía", "Tamara", "Victoria",
				"Xenia", "Yara", "Zoila", "Amanda", "Beatriz", "Cecilia", "Débora", "Emilia", "Fátima", "Gabriela",
				"Herminia", "Irma", "Jazmín", "Karen", "Liliana", "Manuela", "Nadia", "Olivia", "Paulina", "Rosario",
				"Susana", "Teresa", "Viviana");

	}

	public boolean getBoolean() {
		int num = (int) (Math.random() * 2);

		return num == 0;

	}
	
	
	public <T> T getElement(  List<T> elementos  ){
		
		int pos = (int) (Math.random() * elementos.size());

		return elementos.get(pos);
	}

	public String getNombre() {
		
		String nombre = this.getElement(this.nombres);
		
		boolean minus = getBoolean();

		return minus ? nombre.toLowerCase() : nombre;

	}

	
	public String getApellido() {
		
		String apellido = this.getElement(this.apellidos);
		
		boolean minus = getBoolean();

		return minus ? apellido.toLowerCase() : apellido;

	}

	
	public int getInt(int min, int max) {
		return min + (int) (Math.random() * (max - min));
	}

	public double getDouble(double min, double max) {
		return getInt((int) (min * 100), (int) (max * 100)) / 100.0;
	}

}
