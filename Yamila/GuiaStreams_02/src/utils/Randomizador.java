package utils;


import java.util.Arrays;
import java.util.List;

public class Randomizador {

	private List<String> nombres;
	private List<String> apellidos;

	public Randomizador() {
		this.apellidos = Arrays.asList(
	            "Gonz�lez", "Rodr�guez", "L�pez", "Fern�ndez", "P�rez", "Garc�a", "Mart�nez", "S�nchez", "Romero", "D�az",
	            "Torres", "V�zquez", "Castro", "Su�rez", "Ramos", "Gim�nez", "Herrera", "Dom�nguez", "Moreno", "Flores",
	            "Ch�vez", "Molina", "Ortega", "Silva", "Delgado", "Cabrera", "Rojas", "Acosta", "M�ndez", "Aguilar",
	            "Cruz", "Paredes", "Vargas", "Salazar", "Arias", "Ponce", "Alvarez", "Ben�tez", "Carrasco", "Cort�s",
	            "Espinoza", "Ibarra", "Montoya", "Pe�a", "R�os", "Valdez", "Vera", "Mu�oz", "Escobar", "Figueroa", "Miranda",
	            "Campos", "Navarro", "Quintero", "Rivera", "Soto", "Mej�a", "Burgos", "Luna", "Morales", "Mendoza",
	            "Reyes", "Guzm�n", "Serrano", "Vega", "Barrios", "Blanco", "Palacios", "Zambrano", "Cisneros", "Ortiz",
	            "Pacheco", "Fuentes", "Maldonado", "Bravo", "Esquivel", "Peralta", "Sol�s", "C�ceres", "Villalba", "Caballero",
	            "Santana", "Quiroga", "Tapia", "Alvarado", "Bustos", "Ferrari", "Lagos", "Cordero", "Montes", "Reynoso",
	            "Dur�n", "Vallejo", "Arroyo", "Soria", "Villanueva", "Medina", "Parra", "Riquelme", "Arce", "Escalante",
	            "Orozco", "Paredes", "Z��iga", "Segovia", "T�llez", "Pinto", "Guerra", "Montero", "Mora", "Rold�n",
	            "Farf�n", "Barrera", "Carrillo", "C�rdenas", "Contreras", "Cordero", "Arroyo", "Aguirre", "Avenda�o", "Galindo",
	            "Valencia", "Valverde", "Garay", "Alonso", "Montiel", "S�enz", "Prado", "Marrero", "Venegas", "Portillo",
	            "Toledo", "Barrag�n", "Berm�dez", "Delgado", "Cano", "Cuevas", "Andrade", "Valladares", "Nieto", "Escobedo",
	            "Fonseca", "Chac�n", "Tovar", "Espinosa", "Amaya", "Cuellar", "Reyna", "Guerrero", "Navarrete", "Pizarro",
	            "Rinc�n", "Sandoval", "Tejada", "Padilla", "Leiva", "L�pez", "Jim�nez", "Oliva", "Ram�rez", "Ferrer",
	            "Almeida", "Barros", "Campos", "Godoy", "Izquierdo", "Jacinto", "Monz�n", "Ojeda", "Perdomo", "Rivas"
	        );

		this.nombres = Arrays.asList("Alejandro", "Bruno", "Carlos", "Daniel", "Emilio", "Fernando", "Gabriel", "Hugo",
				"Iv�n", "Javier", "Kurt", "Luis", "Manuel", "Nicol�s", "Oscar", "Pablo", "Quint�n", "Ramiro", "Sergio",
				"Tom�s", "Ulises", "Vicente", "Walter", "Xavier", "Yago", "Zacar�as", "Adri�n", "Bernardo", "C�sar",
				"Diego", "Eduardo", "Fabi�n", "Gustavo", "H�ctor", "Ignacio", "Jorge", "Kevin", "Leandro", "Mariano",
				"N�stor", "Octavio", "Pedro", "Roberto", "Santiago", "Tob�as", "Uriel", "V�ctor", "William", "Ximeno",
				"Yahir", "Alfonso", "Bautista", "Cristian", "David", "Ezequiel", "Federico", "Gerardo", "Hern�n",
				"Iker", "Julio", "Kilian", "Leonardo", "Mat�as", "Nahuel", "Omar", "Patricio", "Rafael", "Sebasti�n",
				"Thiago", "Valent�n", "Andr�s", "Brayan", "Claudio", "Dar�o", "Esteban", "Facundo", "Guillermo",
				"Homero", "Ismael", "Jonathan", "Lucas", "Mauricio", "Nelson", "Orlando", "Pascual", "Ricardo", "Sim�n",
				"Teodoro", "Vladimir", "Yamil", "Ana", "B�rbara", "Camila", "Diana", "Elena", "Florencia", "Gabriela",
				"Helena", "Isabel", "Julia", "Karla", "Laura", "Mar�a", "Natalia", "Olga", "Patricia", "Raquel", "Sara",
				"Tatiana", "�rsula", "Valeria", "Wendy", "Ximena", "Yolanda", "Zulema", "Adriana", "Bel�n", "Carla",
				"Daniela", "Elisa", "Fernanda", "Graciela", "Hilda", "Ivana", "Jessica", "Karina", "Lorena", "M�nica",
				"Nuria", "Ofelia", "Paola", "Roc�o", "Silvia", "Teresa", "Ver�nica", "Yadira", "Zaira", "Alba",
				"Blanca", "Carolina", "Dolores", "Estefan�a", "Fiorella", "Gloria", "Hayd�e", "In�s", "Jimena",
				"Katherine", "Luz", "Magdalena", "Noelia", "Oriana", "Pilar", "Rita", "Sof�a", "Tamara", "Victoria",
				"Xenia", "Yara", "Zoila", "Amanda", "Beatriz", "Cecilia", "D�bora", "Emilia", "F�tima", "Gabriela",
				"Herminia", "Irma", "Jazm�n", "Karen", "Liliana", "Manuela", "Nadia", "Olivia", "Paulina", "Rosario",
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
